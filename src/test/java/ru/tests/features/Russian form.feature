
Feature: Site initialization

  @test
  Scenario: Going to the Home page

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
      |Country|
      |City|
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

# todo redo all methods that are indent for Russian form to launch it and test in Russian