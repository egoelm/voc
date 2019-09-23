from unittest import expectedFailure

from ..utils import TranspileTestCase

# class DateTimeModuleTests(TranspileTestCase):

# class TimeDeltaTests(TranspileTestCase):

#class DateTimeTests(TranspileTestCase):
    #######################################################
    # __file__


    #######################################################

    #def test_creation(self):
    #    self.assertCodeExecution("""
    #        from datetime import datetime
    #        print(datetime(4, 10, day=11))
    #        print(datetime(4, 10, 11))
    #        print(datetime(4, month=10, day=11))
    #        print(datetime(year=4, month=10, day=11))
    #        print(datetime(14, 10, day=11))
    #        print(datetime(14, 10, 11))
    #        print(datetime(14, month=10, day=11))
    #        print(datetime(year=14, month=10, day=11))
    #        print(datetime(141, 10, day=11))
    #        print(datetime(141, 10, 11))
    #        print(datetime(141, month=10, day=11))
    #        print(datetime(year=141, month=10, day=11))
    #        print(datetime(1413, 10, day=11))
    #        print(datetime(1413, 10, 11))
    #        print(datetime(1413, month=10, day=11))
    #        print(datetime(year=1413, month=10, day=11))""")
    #
    #######################################################

    # def test_creation_invalid(self):
    #     self.assertCodeExecution("""
    #         from datetime import datetime
    #         try:
    #             datetime(14, month=10, 11)
    #         except SyntaxError as e:
    #             print(e)

    #         try:
    #             datetime(year=14, month=10, 11)
    #         except SyntaxError as e:
    #             print(e)

    #         try:
    #             datetime(year=14, 10, day=11)
    #         except SyntaxError as e:
    #             print(e)
            
    #         try:
    #             datetime(year=14, 10, 11)
    #         except SyntaxError as e:
    #             print
    #         """)


class DateTests(TranspileTestCase):
    #######################################################
    #######################################################
    # __file__
    @expectedFailure
    def test___repr__(self):
        self.assertCodeExecution("""
            from datetime import date
            print(date.__repr__)
            """)

    #######################################################


    #######################################################

    def test_creation(self):
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