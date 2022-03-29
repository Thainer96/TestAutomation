Feature: Automation process in Zoe

  Background: 
    Given a user enters the page

  @assignAppointment
  Scenario Outline: appointment scheduling
    When verify that you already have an appointment with the following data  <user><duration><schedule>
    And schedule a new appointment with the data <dayAppointment><timeZone><appointmentTime><Month><typeConference>
    Then appointment assignment is validated <confirmationMessage><appointmentTime>

    Examples: 
      | user           | duration     | schedule             | dayAppointment | timeZone       | appointmentTime | Month   | typeConference | confirmationMessage         |
      | "Aaron Morton" | "60 Minutes" | "9:00 AM - 10:00 AM" | "18"           | "Central Time" | "4:00 pm"       | "April" | "Phone Call"   | "Successfully rescheduled!" |

  @cancelAppointment
  Scenario Outline: Cancelly Appointment
    When select to button cancel metting
    And select reason of cancell <razonCancell>
    And select advisor option <advisorOpcion><razonCancell>
    Then allows you to cancel the appointment showing following message "has been cancelled."

    Examples: 
      | razonCancell                 | advisorOpcion |
      | "I already found an Advisor" | "Outside Zoe" |

  @validateAvailableHours
  Scenario Outline: Validate Hours for Zone
    When one day is selected <day>
    And a time zone is selected <Zone>
    Then Validate the displayed List
      | Hours    |
      | 9:00 am  |
      | 9:30 am  |
      | 10:00 am |
      | 10:30 am |
      | 11:00 am |
      | 11:30 am |
      | 12:00 pm |
      | 12:30 pm |
      | 1:00 pm  |
      | 1:30 pm  |
      | 2:00 pm  |
      | 2:30 pm  |
      | 3:00 pm  |
      | 3:30 pm  |
      | 4:00 pm  |
      | 4:30 pm  |
      | 5:00 pm  |
      | 5:30 pm  |

    Examples: 
      | Zone           | day  |
      | "Eastern Time" | "30" |
