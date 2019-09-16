from unittest import expectedFailure

from ..utils import TranspileTestCase

class DateTimeModuleTests(TranspileTestCase):
    def test_ceil(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.timeDelta(4.5))
            """)

    def test_timeDelta(self):
        self.assertCodeExecution("""
            import datetime
            """)
            
    @expectedFailure
    def test_datetime(self):
        self.assertCodeExecution("""
            import datetime
            """)