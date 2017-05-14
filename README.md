# Form-Master

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
compile 'me.riddhimanadib.form-master:form-master:1.0.0'
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
FormHeader header = FormHeader.createInstance().setTitle("Personal Info");
FormElement element = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_EMAIL).setTitle("Email");

// add them in a list
List<FormObject> formItems = new ArrayList<>();
formItems.add(header);
formItems.add(element);

// build and display the form
mFormBuilder.addFormElements(formItems);
mFormBuilder.refreshView();
```
3. Now build and run!!


## Reference

### Item Definition

#### Header:
``` 'java'
FormHeader header = FormHeader.createInstance().setTitle("Personal Info");
```

#### Regular Elements:
 
**General object format**
``` 'java'
FormElement element = FormElement.createInstance()
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
FormElement element = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_EMAIL).setTitle("Email");

// phone number input
FormElement element = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_PHONE).setTitle("Phone");

// single line text input
FormElement element = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_TEXT_SINGLELINE).setTitle("Location");

// multi line text input (default 4)
FormElement element = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_TEXT_MULTILINE).setTitle("Address");

// number element input
FormElement element = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_NUMBER).setTitle("Zip Code");

// date picker input
FormElement element = FormElement.createInstance().setType(FormElement.TYPE_PICKER_DATE).setTitle("Date");

// time picker input
FormElement element = FormElement.createInstance().setType(FormElement.TYPE_PICKER_TIME).setTitle("Time");

// password input
FormElement element = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_PASSWORD).setTitle("Password");

// single item picker input
List<String> fruits = new ArrayList<>();
fruits.add("Banana");
fruits.add("Orange");
fruits.add("Mango");
fruits.add("Guava");
FormElement element = FormElement.createInstance().setType(FormElement.TYPE_SPINNER_DROPDOWN).setTitle("Single Item").setOptions(fruits);

// multiple items picker input
List<String> fruits = new ArrayList<>();
fruits.add("Banana");
fruits.add("Orange");
fruits.add("Mango");
fruits.add("Guava");
FormElement element = FormElement.createInstance().setType(FormElement.TYPE_PICKER_MULTI_CHECKBOX).setTitle("Multi Items").setOptions(fruits);
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
