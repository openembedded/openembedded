#
# Tasks specific to QA testing of packages
#
# For native and cross packages we want to test
# immediately for other packages we want to package
# the tests including a test
#


addtask test after do_compile
test_do_test () {
    :
}

