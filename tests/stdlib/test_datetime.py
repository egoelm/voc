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
            print(datetime.min)
            print(datetime.max)
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

    #__repr__
    #@expectedFailure
    #def test___repr__(self):
    #    self.assertCodeExecution("""
     #       from datetime import date
      #      print(date.__repr__)
       #     """)

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
            print(date(14, 10, day=11))
            print(date(14, 10, 11))
            print(date(14, month=10, day=11))
            print(date(year=14, month=10, day=11))""")

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

    def test_one_arg_w_month(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                date(month=2)
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
