require cmake.inc

inherit cmake

do_configure_append() {
	sed -i -e 's,HAVE_GLIBC_STRERROR_R__TRYRUN_OUTPUT-ADVANCED:INTERNAL=1,HAVE_GLIBC_STRERROR_R__TRYRUN_OUTPUT-ADVANCED:INTERNAL=0,' CMakeCache.txt
}

