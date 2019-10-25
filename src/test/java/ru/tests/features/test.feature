
Feature: Site initialization

  @test
Scenario: Going to the Home page
    Given some map of values
      |a|1|
      |b|2|
      |c|3|
    And turning off a cookie pop-up message
 # When applying a code to get a sale for pizza order
 #  |10000|
  # |269789     |
    When going to the page "Mistery Shopper" to fill up a form for a free pizza
  #And checking that titles match
 # ||
    Then checking that following elements are present of the form
    # todo where this method should be located?
    # todo fill up cells below:
   # |Станьте тайным покупателем|
   |Страна|
   |Город|
    #|Адрес пиццерии|
    #|Имя|
    #|Дата рождения|
    #|Телефон|
    #|Вконтакте|
    #|Вы или ваши знакомые работали в Додо Пицце?|
    #|Нет                                        |
    #|Да, раньше                                 |
    #|Да, прямо сейчас                           |
    #|Что вы готовы проверять?                   |
    #|Ресторан                                   |
    #|Доставку                                   |
    #|И то, и другое                             |
    #|Согласен на обработку персональных данных  |
    #|Согласен на получение рекламных рассылок|
    #|Отправить                               |

  And filling up the "Mistery Shopper" form
    |Страна|Беларусь|
    |Город|Брест|
    |Адрес пиццерии|Малиновка|

  public class StepDef{

  private static StepDefs instance = new StepDefs();

  private static IDodoControlSteps iDodoControlSteps;
  private static IElementsSteps iElementSteps;
  private static IMainClassSteps iMainSteps;

  public static IDodoControlSteps getDodoControlSteps(){
  if(iDodoControlSteps == null){
  iDodoControlSteps = new DodoControlStepsImpl();
  }
  return iDodoControlSteps;
  }
  public static void setDodoControl(IDodoControlSteps iDodoControlSteps){
  StepDef.iDodoControlSteps = iDodoControlSteps;
  }
  public static IElementsSteps getElementSteps(){
  if(iElementSteps == null){
  iElementSteps = new ElementsStepsImpl();
  }
  return iElementSteps;
  }
  public static void setElementSteps(IElementsSteps iElementSteps){
  StepDef.iElementSteps = iElementSteps;
  }
  public static getMainClassSteps(){
  if(iMainSteps == null){
  iMainSteps = new MainStepsImpl();
  }
  return iMainSteps;
  }
  public static void setMainClassSteps(IMainClassSteps iMainSteps){
  StepDef.iMainSteps = iMainSteps;
  }
  }

  public class ElementsStepDefinitions{

  Поля заполнены данными
  public void fillFields(DataTable dataTable) throws Exception{
  getElementSteps.fillFields(dataTable);
  }
  }

  public class ElementsStepsImpl implements IElementsSteps{
  @Override
  public void fillFields(DataTable dataTable) throws PageException {
  Map<String, String> elemValuesMap = dataTable.asMap(String.class, String.class);

  }

  @Override
  public void checkTextOnElement(WebElement element, String expectedText) throws Exception{
  Assert.assertTrue("Actual value is not equal to expected one", element.getText().contains(expectedText));
  }
  }
