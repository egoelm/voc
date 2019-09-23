from unittest import expectedFailure

from ..utils import TranspileTestCase

# class DateTimeModuleTests(TranspileTestCase):

# class TimeDeltaTests(TranspileTestCase):

# class DateTimeTests(TranspileTestCase):

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
    #        print(datetime(year=1413, month=10, day=11))
    #        """)

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
