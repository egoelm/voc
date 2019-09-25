from unittest import expectedFailure

from ..utils import TranspileTestCase

# class DateTimeModuleTests(TranspileTestCase):

# class TimeDeltaTests(TranspileTestCase):


# class DateTimeTests(TranspileTestCase):
#     def test_creation(self):
#         self.assertCodeExecution("""
#             from datetime import datetime
#             print(datetime(1993,5,17).min)
#             print(datetime(1993,5,17).max)
#             print (datetime(1993,5,17).year)
#             print (datetime(1993,5,17).month)
#             print (datetime(1993,5,17,20,30,12,34).hour)
#             print (datetime(1993,5,17,20,30,12,34).minute)
#             print (datetime(1993,5,17,20,30,12,34).second)
#             print (datetime(1993,5,17,20,30,12,34).microsecond)
#         """)

class DateTests(TranspileTestCase):

    #######################################################

    #######################################################
    # __file__

    #__repr__
    #@expectedFailure
    #def test___repr__(self):
    #    self.assertCodeExecution("""
    #        from datetime import date
    #        print(date.__repr__)
    #       """)

    #######################################################

    def test_creation(self):
        self.assertCodeExecution("""
            from datetime import date
            print(date(14, 10, day=11))
            print(date(14, 10, 11))
            print(date(14, month=10, day=11))            
            print(date(year=14, month=10, day=11))
            print(date(1,1,1))
       
        """)


    def test_year_too_large(self):
        self.assertCodeExecution("""
        from datetime import date
        try:
            date(14444, 10, 11)
        except ValueError as err:
            print(err)
        
        """)

    def test_month_too_large(self):
        self.assertCodeExecution("""
        from datetime import date
        try:
            date(14, 122, 11)
        except ValueError as err:
            print(err)
        
        """)

    def test_day_too_large(self):
        self.assertCodeExecution("""
        from datetime import date
        try:
            date(14, 12, 111)
        except ValueError as err:
            print(err)
        """)


    def test_year_wrong_type(self):
        self.assertCodeExecution("""
        from datetime import date
        try:
            date(14.0, 12, 11)
        except TypeError as err:
            print(err)
        
        """)

    def test_month_wrong_type(self):
        self.assertCodeExecution("""
        from datetime import date
        try:
            date(14, 12.0, 11)
        except TypeError as err:
            print(err)
        
        """)

    def test_day_wrong_type(self):
        self.assertCodeExecution("""
        from datetime import date
        try:
            date(14, 12, 11.0)
        except TypeError as err:
            print(err)
        
        """)

    def test_two_many_args(self):
        self.assertCodeExecution("""
        from datetime import date
        try:
            date(14, 12, 10,1)
        except TypeError as err:
            print(err)
        
        """)

    def test_two_few_args(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                date(14, 12)
            except TypeError as err:
                print(err)
            
            """)
    def test_two_few_args2(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                date(month=14, day=12)
            except TypeError as err:
                print(err)
            
            """)

    def test_two_few_args3(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                date(year=14, day=12)
            except TypeError as err:
                print(err)  
            """)

    def test_one_arg_no_month(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                date(year=14)
            except TypeError as err:
                print(err)
            
            """)



    def test_two_many_args(self):
        self.assertCodeExecution("""
        from datetime import date
        try:
            date(14, 12, 10, 1)
        except TypeError as err:
            print(err)
        
        """)

    def test_two_few_args(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                date(14, 12)
            except TypeError as err:
                print(err)
            
            """)

    def test_two_few_args_no_yr(self):
            self.assertCodeExecution("""
            from datetime import date
            try:
                date(month=14, day=12)
            except TypeError as err:
                print(err)
            
            """)

    def test_two_few_args_no_month(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                date(year=14, day=12)
            except TypeError as err:
                print(err)  
            """)

    def test_one_arg_no_month(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                date(year=14)
            except TypeError as err:
                print(err)
            
            """)

    def test_one_arg_year_float(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                date(year=14.0)
            except TypeError as err:
                print(err)
         
            """)

    def test_one_arg_w_month(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                date(month=14.0)
            except TypeError as err:
                print(err)
            """)

    def test_one_arg_w_day(self):
        self.assertCodeExecution("""
        from datetime import date
        try:
            date(day=71)
        except TypeError as err:
            print(err)        
        """)


    def test_no_arg(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                date()
            except TypeError as err:
                print(err)
            """)

    def test_class_methods(self):
        #Test function today()
        self.assertCodeExecution("""
            from datetime import date
            print(date.today())
            """)

    def test_instance_methods(self):
        #Test function weekday()
        self.assertCodeExecution("""
            from datetime import date
            for d in range(1,13):
                x = date(2019,d,d)
                print(x.weekday())
            """)



    def test_ctime(self):
        #Test function ctime()
        self.assertCodeExecution("""
            from datetime import date
            for d in range(1,13):
                x = date(1993,12,1)
                print(x.ctime())
            """)

    def test_class_attributes(self):
        #Min function
        self.assertCodeExecution("""
            from datetime import date
            x = date(2019,9,22)
            print(x.min)
            """)
        #Max function
        self.assertCodeExecution("""
            from datetime import date
            x = date(2019,9,22)
            print(x.max)
            """)





