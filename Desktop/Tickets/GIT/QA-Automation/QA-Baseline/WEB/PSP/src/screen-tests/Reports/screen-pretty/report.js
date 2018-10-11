$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Screening_All_results.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#https://jira.polestarglobal.com/browse/SCREEN-661"
    }
  ],
  "line": 6,
  "name": "",
  "description": "Filtering the screening table based on results",
  "id": "",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@Smoke_Testcases"
    },
    {
      "line": 3,
      "name": "@Regression_Testcases"
    },
    {
      "line": 4,
      "name": "@All_results"
    }
  ]
});
formatter.scenario({
  "line": 12,
  "name": "Selection of ship global sanctions check from the filter.",
  "description": "",
  "id": ";selection-of-ship-global-sanctions-check-from-the-filter.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@All_results_dropdown_dropdown_check"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I login to devtest application with valid username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I should be landed in Screening results page",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "check the filter",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "click on the ship name in the first row.",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "validate all the Latest Screening Results accordion",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "close the browser driver",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_login_to_devtest_application_with_valid_username_and_password()"
});
formatter.result({
  "duration": 18484328382,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_should_be_landed_in_Screening_results_page()"
});
formatter.result({
  "duration": 10253645953,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.check_the_filter()"
});
formatter.result({
  "duration": 3536241714,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Ship_name_click.click_on_the_ship_name_in_the_first_row()"
});
formatter.result({
  "duration": 26669589245,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Shipname_accordion.validate_all_the_Latest_Screening_Results_accordion()"
});
formatter.result({
  "duration": 15320488356,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Login.close_the_browser_driver()"
});
formatter.result({
  "duration": 603259169,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Selection of ship global sanctions check from the filter.",
  "description": "",
  "id": ";selection-of-ship-global-sanctions-check-from-the-filter.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 20,
      "name": "@All_results_dropdown_select_the_check_ship_global_sanctions_list"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "I login to devtest application with valid username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "I should be landed in Screening results page",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "check the filter and select Ship global sanction check.",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "Critical value alone should be selected",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "click on the ship name in the first row.",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "validate all the Latest Screening Results accordion",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "validate whether Ship global sanctions list check result is Critical",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "close the browser driver",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_login_to_devtest_application_with_valid_username_and_password()"
});
formatter.result({
  "duration": 16440013868,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_should_be_landed_in_Screening_results_page()"
});
formatter.result({
  "duration": 10641970293,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.check_the_filter_and_select_Ship_global_sanction_check()"
});
formatter.result({
  "duration": 5617350612,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.critical_value_alone_should_be_selected()"
});
formatter.result({
  "duration": 22349564749,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Ship_name_click.click_on_the_ship_name_in_the_first_row()"
});
formatter.result({
  "duration": 26685166638,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Shipname_accordion.validate_all_the_Latest_Screening_Results_accordion()"
});
formatter.result({
  "duration": 15373105605,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.validate_whether_Ship_global_sanctions_list_check_result_is_Critical()"
});
formatter.result({
  "duration": 2106899492,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Login.close_the_browser_driver()"
});
formatter.result({
  "duration": 600511929,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "Selection of port state control check from the filter.",
  "description": "",
  "id": ";selection-of-port-state-control-check-from-the-filter.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 33,
      "name": "@All_results_dropdown_select_the_port_state_control"
    }
  ]
});
formatter.step({
  "line": 35,
  "name": "I login to devtest application with valid username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "I should be landed in Screening results page",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "check the filter and select port state control check",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "Warning value alone should be selected",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "click on the ship name in the first row.",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "validate all the Latest Screening Results accordion",
  "keyword": "Then "
});
formatter.step({
  "line": 41,
  "name": "validate whether port state control check result is Warning",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "close the browser driver",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_login_to_devtest_application_with_valid_username_and_password()"
});
formatter.result({
  "duration": 16503824498,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_should_be_landed_in_Screening_results_page()"
});
formatter.result({
  "duration": 10235724454,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.check_the_filter_and_select_port_state_control_check()"
});
formatter.result({
  "duration": 5621013029,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.warning_value_alone_should_be_selected()"
});
formatter.result({
  "duration": 2104778335,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Ship_name_click.click_on_the_ship_name_in_the_first_row()"
});
formatter.result({
  "duration": 26539173985,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Shipname_accordion.validate_all_the_Latest_Screening_Results_accordion()"
});
formatter.result({
  "duration": 15339234656,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.validate_whether_port_state_control_check_result_is_Warning()"
});
formatter.result({
  "duration": 2114446993,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Login.close_the_browser_driver()"
});
formatter.result({
  "duration": 609247733,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "Selection of ship movement history check from the filter.",
  "description": "",
  "id": ";selection-of-ship-movement-history-check-from-the-filter.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 44,
      "name": "@All_results_dropdown_select_the_ship_movement_history"
    }
  ]
});
formatter.step({
  "line": 46,
  "name": "I login to devtest application with valid username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 47,
  "name": "I should be landed in Screening results page",
  "keyword": "Then "
});
formatter.step({
  "line": 48,
  "name": "check the filter and select ship movement history check",
  "keyword": "Then "
});
formatter.step({
  "line": 49,
  "name": "OK value alone should be selected",
  "keyword": "Then "
});
formatter.step({
  "line": 50,
  "name": "click on the ship name in the first row.",
  "keyword": "Then "
});
formatter.step({
  "line": 51,
  "name": "validate all the Latest Screening Results accordion",
  "keyword": "Then "
});
formatter.step({
  "line": 52,
  "name": "validate whether ship movementhistory check result is OK",
  "keyword": "Then "
});
formatter.step({
  "line": 53,
  "name": "close the browser driver",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_login_to_devtest_application_with_valid_username_and_password()"
});
formatter.result({
  "duration": 16459001933,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_should_be_landed_in_Screening_results_page()"
});
formatter.result({
  "duration": 10695930657,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.check_the_filter_and_select_ship_movement_history_check()"
});
formatter.result({
  "duration": 5626928037,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.ok_value_alone_should_be_selected()"
});
formatter.result({
  "duration": 13074948133,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Ship_name_click.click_on_the_ship_name_in_the_first_row()"
});
formatter.result({
  "duration": 26651280292,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Shipname_accordion.validate_all_the_Latest_Screening_Results_accordion()"
});
formatter.result({
  "duration": 15375810081,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.validate_whether_ship_movementhistory_check_result_is_OK()"
});
formatter.result({
  "duration": 2135337542,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Login.close_the_browser_driver()"
});
formatter.result({
  "duration": 604602854,
  "status": "passed"
});
formatter.scenario({
  "line": 57,
  "name": "Selection of country sanctions check from the filter.",
  "description": "",
  "id": ";selection-of-country-sanctions-check-from-the-filter.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 56,
      "name": "@All_results_dropdown_select_the_Country_sanctions_check"
    }
  ]
});
formatter.step({
  "line": 58,
  "name": "I login to devtest application with valid username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 59,
  "name": "I should be landed in Screening results page",
  "keyword": "Then "
});
formatter.step({
  "line": 60,
  "name": "check the filter and select Country sanctions check",
  "keyword": "Then "
});
formatter.step({
  "line": 61,
  "name": "OK value alone should be selected",
  "keyword": "Then "
});
formatter.step({
  "line": 62,
  "name": "click on the ship name in the first row.",
  "keyword": "Then "
});
formatter.step({
  "line": 63,
  "name": "validate all the Latest Screening Results accordion",
  "keyword": "Then "
});
formatter.step({
  "line": 64,
  "name": "validate whether Country sanctions check result is OK",
  "keyword": "Then "
});
formatter.step({
  "line": 65,
  "name": "close the browser driver",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_login_to_devtest_application_with_valid_username_and_password()"
});
formatter.result({
  "duration": 16819349518,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_should_be_landed_in_Screening_results_page()"
});
formatter.result({
  "duration": 10226634838,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.check_the_filter_and_select_Country_sanctions_check()"
});
formatter.result({
  "duration": 5692973580,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.ok_value_alone_should_be_selected()"
});
formatter.result({
  "duration": 13048877284,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Ship_name_click.click_on_the_ship_name_in_the_first_row()"
});
formatter.result({
  "duration": 26801735073,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Shipname_accordion.validate_all_the_Latest_Screening_Results_accordion()"
});
formatter.result({
  "duration": 15407603779,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.validate_whether_Country_sanctions_check_result_is_Unknown()"
});
formatter.result({
  "duration": 2115714555,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Login.close_the_browser_driver()"
});
formatter.result({
  "duration": 598608589,
  "status": "passed"
});
formatter.scenario({
  "line": 69,
  "name": "Selection of company global sanctions check from the filter.",
  "description": "",
  "id": ";selection-of-company-global-sanctions-check-from-the-filter.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 68,
      "name": "@All_results_dropdown_select_the_Company_global_sanctions"
    }
  ]
});
formatter.step({
  "line": 70,
  "name": "I login to devtest application with valid username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 71,
  "name": "I should be landed in Screening results page",
  "keyword": "Then "
});
formatter.step({
  "line": 72,
  "name": "check the filter and select Company global sanctions check",
  "keyword": "Then "
});
formatter.step({
  "line": 73,
  "name": "Unknown value alone should be selected",
  "keyword": "Then "
});
formatter.step({
  "line": 74,
  "name": "click on the ship name in the first row.",
  "keyword": "Then "
});
formatter.step({
  "line": 75,
  "name": "validate all the Latest Screening Results accordion",
  "keyword": "Then "
});
formatter.step({
  "line": 76,
  "name": "validate whether Company global sanctions check result is Pending",
  "keyword": "Then "
});
formatter.step({
  "line": 77,
  "name": "close the browser driver",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_login_to_devtest_application_with_valid_username_and_password()"
});
formatter.result({
  "duration": 16964493136,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_should_be_landed_in_Screening_results_page()"
});
formatter.result({
  "duration": 10243251426,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.check_the_filter_and_select_Company_global_sanctions_check()"
});
formatter.result({
  "duration": 5584028768,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.unknown_value_alone_should_be_selected()"
});
formatter.result({
  "duration": 8822906447,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Ship_name_click.click_on_the_ship_name_in_the_first_row()"
});
formatter.result({
  "duration": 26499225236,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Shipname_accordion.validate_all_the_Latest_Screening_Results_accordion()"
});
formatter.result({
  "duration": 15379321395,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.validate_whether_Company_global_sanctions_check_result_is_Pending()"
});
formatter.result({
  "duration": 2115297451,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Login.close_the_browser_driver()"
});
formatter.result({
  "duration": 596506534,
  "status": "passed"
});
formatter.scenario({
  "line": 81,
  "name": "Selection of overall screening result option from the filter.",
  "description": "",
  "id": ";selection-of-overall-screening-result-option-from-the-filter.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 80,
      "name": "@All_results_dropdown_select_the_overall_screening_result_by_escalated_results"
    }
  ]
});
formatter.step({
  "line": 82,
  "name": "I login to devtest application with valid username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 83,
  "name": "I should be landed in Screening results page",
  "keyword": "Then "
});
formatter.step({
  "line": 84,
  "name": "check the filter and select overall screening result option",
  "keyword": "Then "
});
formatter.step({
  "line": 85,
  "name": "click on the Escalated results only toggle button",
  "keyword": "Then "
});
formatter.step({
  "line": 86,
  "name": "close the browser driver",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_login_to_devtest_application_with_valid_username_and_password()"
});
formatter.result({
  "duration": 16670373845,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_should_be_landed_in_Screening_results_page()"
});
formatter.result({
  "duration": 10293328989,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.check_the_filter_and_select_overall_screening_result_option()"
});
formatter.result({
  "duration": 5541118380,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.click_on_the_Escalated_results_only_toggle_button()"
});
formatter.result({
  "duration": 10687154083,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Login.close_the_browser_driver()"
});
formatter.result({
  "duration": 605171632,
  "status": "passed"
});
formatter.scenario({
  "line": 90,
  "name": "Selection of overall screening result option from the filter.",
  "description": "",
  "id": ";selection-of-overall-screening-result-option-from-the-filter.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 89,
      "name": "@All_results_dropdown_select_the_overall_screening_result_by_critical"
    }
  ]
});
formatter.step({
  "line": 91,
  "name": "I login to devtest application with valid username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 92,
  "name": "I should be landed in Screening results page",
  "keyword": "Then "
});
formatter.step({
  "line": 93,
  "name": "check the filter and select overall screening result option",
  "keyword": "Then "
});
formatter.step({
  "line": 94,
  "name": "Critical value alone should be selected",
  "keyword": "Then "
});
formatter.step({
  "line": 95,
  "name": "close the browser driver",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_login_to_devtest_application_with_valid_username_and_password()"
});
formatter.result({
  "duration": 16503685084,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_should_be_landed_in_Screening_results_page()"
});
formatter.result({
  "duration": 10276648252,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.check_the_filter_and_select_overall_screening_result_option()"
});
formatter.result({
  "duration": 5545761263,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.critical_value_alone_should_be_selected()"
});
formatter.result({
  "duration": 41540163004,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Login.close_the_browser_driver()"
});
formatter.result({
  "duration": 595396347,
  "status": "passed"
});
formatter.scenario({
  "line": 99,
  "name": "Selection of option and result from the dropdown and checking the buton title according to selection",
  "description": "",
  "id": ";selection-of-option-and-result-from-the-dropdown-and-checking-the-buton-title-according-to-selection",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 98,
      "name": "@All_results_Filter_button_validation_after_selection"
    }
  ]
});
formatter.step({
  "line": 100,
  "name": "I login to devtest application with valid username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 101,
  "name": "I should be landed in Screening results page",
  "keyword": "Then "
});
formatter.step({
  "line": 102,
  "name": "check the filter and select overall screening result option",
  "keyword": "Then "
});
formatter.step({
  "line": 103,
  "name": "click on the Escalated results only toggle button",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_login_to_devtest_application_with_valid_username_and_password()"
});
formatter.result({
  "duration": 16517681872,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_ScreeningResultsPage.i_should_be_landed_in_Screening_results_page()"
});
formatter.result({
  "duration": 10665131394,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.check_the_filter_and_select_overall_screening_result_option()"
});
formatter.result({
  "duration": 5594659074,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition_Screening_AllResults_filter.click_on_the_Escalated_results_only_toggle_button()"
});
formatter.result({
  "duration": 10814924737,
  "status": "passed"
});
});