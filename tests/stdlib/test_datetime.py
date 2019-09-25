from unittest import expectedFailure

from ..utils import TranspileTestCase

# class DateTimeModuleTests(TranspileTestCase):

# class TimeDeltaTests(TranspileTestCase):

class DateTimeTests(TranspileTestCase):

    def test_creation(self):
       self.assertCodeExecution("""
           from datetime import datetime
           print(datetime(1,2,3))
           print(datetime(1,2,day=3))
           print(datetime(1,month=2,day=3))
           print(datetime(year=1,month=2,day=3))

           print(datetime(11,12,13))
           print(datetime(111,12,13))
           print(datetime(1111,12,13))
           
           print(datetime(1,1,1,0,0,0))
           print(datetime(1,1,1,0,0,0,0))
           print(datetime(9999,12,31,23,59,59))
           print(datetime(9999,12,31,23,59,59,999999))
           
           print(datetime(1,2,3,4,5,6,7))
           print(datetime(1,2,3,4,5,6,1117))
           print(datetime(1,2,3,4,5,6,111117))
           """)

    # The following test will not succeed because the microseconds will differ.
    # def test_today(self):
    #     self.assertCodeExecution("""
    #         from datetime import datetime
    #         print(datetime.today())
    #     """)
    
    def test_date(self):
        self.assertCodeExecution("""
            from datetime import datetime
            print(datetime(1993, 5, 17).date())
            print(datetime(13, 2, 20).date())
            print(datetime(1700, 6, 3).date())
            print(datetime(400, 1, 28).date())
            print(datetime(2007, 3, 17).date())
            print(datetime(1843, 12, 1).date())
            print(datetime(4000, 11, 10).date())
        """)

    def test_class_attributes(self):
        self.assertCodeExecution("""
            from datetime import datetime
            print(datetime(1993,5,17).min)
            print(datetime(1993,5,17).max)
            print (datetime(1993,5,17).year)
            print (datetime(1993,5,17).month)
            print (datetime(1993,5,17,20,30,12,34).hour)
            print (datetime(1993,5,17,20,30,12,34).minute)
            print (datetime(1993,5,17,20,30,12,34).second)
            print (datetime(1993,5,17,20,30,12,34).microsecond)
        """)


    # TODO: fix exceptions
    # def test_creation_invalid(self):
    #     self.assertCodeExecution("""
    #         from datetime import datetime
    #         try:
    #             datetime(14, month=10, 11)
    #         except SyntaxError as e:
    #             print(e)
    #         """)

class DateTests(TranspileTestCase):
    #######################################################
    #######################################################
    # __file__
    #@expectedFailure
    # def test___repr__(self):
    #     self.assertCodeExecution("""
    #         from datetime import date
    #         print(date.__repr__)
    #         """)

    #######################################################


    #######################################################

    def test_creation(self):
        self.assertCodeExecution("""
            from datetime import date
            print(date(14, 10, day=11))
            print(date(14, 10, 11))
            print(date(14, month=10, day=11))
            print(date(year=14, month=10, day=11))""")
