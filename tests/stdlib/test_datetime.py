from unittest import expectedFailure

from ..utils import TranspileTestCase

# class DateTimeModuleTests(TranspileTestCase):

# class TimeDeltaTests(TranspileTestCase):

class DateTimeTests(TranspileTestCase):

    def test_creation(self):
       self.assertCodeExecution("""
           from datetime import datetime
           print(datetime(4, 10, day=11))
           print(datetime(4, 10, 11))
           print(datetime(4, month=10, day=11))
           print(datetime(year=4, month=10, day=11))
           print(datetime(14, 10, day=11))
           print(datetime(14, 10, 11))
           print(datetime(14, month=10, day=11))
           print(datetime(year=14, month=10, day=11))
           print(datetime(141, 10, day=11))
           print(datetime(141, 10, 11))
           print(datetime(141, month=10, day=11))
           print(datetime(year=141, month=10, day=11))
           print(datetime(1413, 10, day=11))
           print(datetime(1413, 10, 11))
           print(datetime(1413, month=10, day=11))
           print(datetime(year=1413, month=10, day=11))
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

    
    def test_year_too_large(self):
        self.assertCodeExecution("""
        from datetime import datetime
        try:
            datetime(19999, 10, 11)
        except ValueError as err:
            print(err)
        
        """)    

    def test_year_too_small(self):
        self.assertCodeExecution("""
        from datetime import datetime
        try:
            datetime(0, 10, 11)
        except ValueError as err:
            print(err)
        
        """)  

    def test_month_too_large(self):
        self.assertCodeExecution("""
        from datetime import datetime
        try:
            datetime(14, 41, 11)
        except ValueError as err:
            print(err)
        
        """)  
        
    def test_month_too_small(self):
            self.assertCodeExecution("""
        from datetime import datetime
        try:
            datetime(0, 0, 11)
        except ValueError as err:
            print(err)
        
        """)       
    
    # def test_creation_invaild_type_str(self):
    #         self.assertCodeExecution("""
    #     from datetime import datetime
    #     try:
    #         datetime("ss", 0, 11)
    #     except ValueError as err:
    #         print(err)

    #     """) 

    # def test_creation_invaild_type_float(self):
    #         self.assertCodeExecution("""
    #     from datetime import datetime
    #     try:
    #         datetime(14.0, 0, 11)
    #     except ValueError as err:
    #         print(err)

    #     """)