# Form-Master

[ ![Download](https://api.bintray.com/packages/adib2149/maven/form-master/images/download.svg) ](https://bintray.com/adib2149/maven/form-master/_latestVersion)

> Easily build big and bigger forms with minimal effort

![](https://github.com/adib2149/FormMaster/blob/master/screenshot/screenshot1.gif)
![](https://github.com/adib2149/FormMaster/blob/master/screenshot/screenshot2.gif)
![](https://github.com/adib2149/FormMaster/blob/master/screenshot/screenshot3.gif)

This library aids in building bigger forms on-the-fly. Forms with large number of elements can easily be added programmatically within a few minutes.


## Features
- Easily build big and bigger forms with minimal effort
- Fast color change as needed


## Installation
Add this in your app's **build.gradle** file:
```
compile 'me.riddhimanadib.form-master:form-master:1.1.0'
```


## How to use
1. Add a Recyclerview anywhere in the layout where you want your list to be shown (If confused, look at the examples in this repo).

``` 'xml'
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <android.support.v7.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:id="@+id/recyclerView"
        android:descendantFocusability="beforeDescendants" />

</LinearLayout>
```

2. Add the Form Elements programmatically in your activity
``` 'java'
// initialize variables
mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
mFormBuilder = new FormBuildHelper(this, mRecyclerView);

// declare form elements
FormHeader header = FormHeader.createInstance("Personal Info");
FormElementTextEmail element = FormElementTextEmail.createInstance().setTitle("Email").setHint("Enter Email");
        
// add them in a list
List<FormObject> formItems = new ArrayList<>();
formItems.add(header);
formItems.add(element);

// build and display the form
mFormBuilder.addFormElements(formItems);
mFormBuilder.refreshView();
```
3. Now build and run!!

### Changelog

####v1.1.0
1. New FormElement type: Switch.
2. New way to define the form elements.
2. Can set Titles in alert dialogs for Date and Time type form element.
3. Can set Positive and negative texts for Date, Time and Switch type form elements.
4. Can set Date and Time formats (if unset, default format will be used).


## Reference

### Item Definition

#### Header:
``` 'java'
FormHeader header = FormHeader.createInstance("Personal Info");
```

#### Regular Elements:
 
**General object format**
``` 'java'
<Class> element = <Class>.createInstance()
    .setTag(101123151) // optional tag to uniquely identify the elemnt for later use
    .setType(FormElement.TYPE_PICKER_MULTI_CHECKBOX) // setting input type
    .setTitle("Pick your favourite fruit") // setting title
    .setValue("Banana") // setting value of the field, if any
    .setOptions(fruits) // setting pickable options, if any
    .setHint("e.g. banana, guava etc") // setting hints, if any
    .setRequired(false); // marking if the form element is required to be filled to make the form valid, include if needed
```

**Samples:**
``` 'java'
// email input
FormElementTextEmail element = FormElementTextEmail.createInstance().setTitle("Email").setHint("Enter Email");

// phone number input
FormElementTextPhone element = FormElementTextPhone.createInstance().setTitle("Phone").setValue("+8801712345678");

// single line text input
FormElementTextSingleLine element = FormElementTextSingleLine.createInstance().setTitle("Location").setValue("Dhaka");

// multi line text input (default 4)
FormElementTextMultiLine element = FormElementTextMultiLine.createInstance().setTitle("Address");

// number element input
FormElementTextNumber element = FormElementTextNumber.createInstance().setTitle("Zip Code").setValue("1000");

// date picker input
FormElementPickerDate element = FormElementPickerDate.createInstance().setTitle("Date").setDateFormat("MMM dd, yyyy");

// time picker input
FormElementPickerTime element = FormElementPickerTime.createInstance().setTitle("Time").setTimeFormat("KK hh");

// password input
FormElementTextPassword element = FormElementTextPassword.createInstance().setTitle("Password").setValue("abcd1234");

// switch input
FormElementSwitch element = FormElementSwitch.createInstance().setTitle("Frozen?").setSwitchTexts("Yes", "No");

// single item picker input
List<String> fruits = new ArrayList<>();
fruits.add("Banana");
fruits.add("Orange");
fruits.add("Mango");
fruits.add("Guava");
FormElementPickerSingle element = FormElementPickerSingle.createInstance().setTitle("Single Item").setOptions(fruits).setPickerTitle("Pick any item");

// multiple items picker input
List<String> fruits = new ArrayList<>();
fruits.add("Banana");
fruits.add("Orange");
fruits.add("Mango");
fruits.add("Guava");
FormElementPickerMulti element = FormElementPickerMulti.createInstance().setTitle("Multi Items").setOptions(fruits).setPickerTitle("Pick one or more").setNegativeText("reset");
```

### Set form element value change listener to get changed value instantly
While creating new instance of FormBuildHelper, add a listener in the constructor

Have a look at the example code for details

``` 'java'
FormBuildHelper mFormBuilder = new FormBuildHelper(this, mRecyclerView, new OnFormElementValueChangedListener() {
    @Override
    public void onValueChanged(FormElement formElement) {
        // do anything here with formElement.getValue()
    }
}
);
```

### Set unique tags for form elements (for later value retrieval)
Just add a unique tag for the element
``` 'java'
FormElement element = FormElement.createInstance()
    .setTag(2149) // unique tag number to identify this element
    .setType(FormElement.TYPE_PICKER_MULTI_CHECKBOX)
    .setTitle("Pick your favourite fruit");
```

### Get value for unique form elements
Use the unique tag assigned earlier to retrieve value (See examples in this repo)
``` 'java'
FormElement targetElement = mFormBuilder.getFormElement(2149);
String targetValue = targetElement.getValue();
```

### Check if form is valid
Use this method if you need to check whether the required elements of the form is completed
```'java'
mFormBuilder.isValidForm(); // returns boolean whether the form is valid or not
```

### Form accent color change
If you want to change the colors, just override the colors in your **colors.xml** file:
```'xml'
<color name="colorFormMasterHeaderBackground">#DDDDDD</color>
<color name="colorFormMasterHeaderText">#000000</color>
<color name="colorFormMasterElementBackground">#FFFFFF</color>
<color name="colorFormMasterElementTextTitle">#222222</color>
<color name="colorFormMasterElementTextValue">#000000</color>
<color name="colorFormMasterDivider">#DDDDDD</color>
```

### Form UI change
If you want to change how the forms look, just override the layout xml named form_element.xml and/or form_element_header.xml in your project.

Just make sure to keep the ID name same as it is in the library for the components.
```
android:id="@+id/formElementTitle"
android:id="@+id/formElementValue"
```

## Contributing
Send Pull Requests and you're in!! Alternatively, you can start adding issues here in this repo!
 

License
-----------------
This Library is released under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
