require dietlibc-cvs.inc
require dietlibc.inc

inherit test

do_test() {
    # Testsuite does not build for ARM; try it nevertheless but ignore errors
    dietlibc_build_tests -k || :
}
