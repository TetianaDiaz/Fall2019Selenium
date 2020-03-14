package com.officeHours;

public class SeleniumOH3 {

    /*
    1. Locators
    <button class="btn btn-primary" onclick="button1()">Button 1</button>
    (red/purple) <button>  --> these are tags (opening and closing tags)
    (orange) class, onclick, value  --> attributes
    (blue/green) "btn btn-primary", "button1()" --> value
    (grey/black) Button 1 --> Text

    Example:
    <div id="page-footer" class="row">

    Tags  -->  <div>
      Attributes --> id, class
      Values --> "page-footer", "row"

      **** attribute = "value" ****

Most cases a locator will require to be unique
      8 Locators:

      Text is between the 'opening' and 'closing' tag

      1. id (attribute)
      2. tagName
      3. className (class)(attribute)
      4. name
      5. linkText
      6. partialLinkText
      7. Xpath
      8. cssSelector

      Which one to choose?
      1. id
      2. cssSelector
      3. Xpath

      LinkText{
      <a href="www.google.com">Autocomplete</a>

      Tag --> <a>
        Attribute --> href
        Value -->"/autocomplete"
        Text --> Autocomplete

        <a></a> --> This is the tag for link
        href --> url, end point for navigation

        For linkText we have to use the whole text  --> "Autocomplete"
        }

        partialLinkText{
        <a href="www.google.com">Autocomplete</a>
        We only need a portion of the text
        Portion of text  -->  "Auto"

        <a href="/javascript_error">JAvaScript onload event error</a>

        linkTetx --> "JavaScript onload event error"
        partialLinkText --> "onload"
        partialLinkTExt --> "JavaScript"
        partialLinkText --> "event"
        }

        className vs name{
        <button class="btn btn-primary" onclick="button2()"
                name="button2">Button 2</button>
                Tag --> button
                Attributes --> class, onclick, name
                Value --> "button2", "button2()", "btn btn-primary"

                className Locator will find element with --> class attribute
                name locator will find the element with --> name attribute
                }

      Xpath{
             1. Absolute Xpath(this is not recommended)
             begin with single dash
             /html/body/div/div[2]/div/div[1]/button[1]
             2. Relative Xpath
             begins with double slash


                }





      }


     */
}
