# This tests the BeagleBoard-xM memory using 'mtest'
#
# While running, LED D7 (USR0) toggles within about 10 seconds
# On fail, LED D6 (USR1) is on
# On pass, LED D7 (USR0) stops toggling and LED D6 (USR1) is off
#
# Completion occurs then the u-boot call stack overflows
setenv test_mem 'mtest 0x8fff0000 0x90010000 0 0x20'
setenv test_on 'if run test_mem; then led 0 on; run test_off; else led 1 on; fi'
setenv test_off 'if run test_mem; then led 0 off; run test_on; else led 1 on; fi'
setenv test 'led all off; run test_on'
run test
