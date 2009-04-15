require glibc_${PV}.bb
require glibc-initial.inc
require glibc-multilib.inc

do_configure_prepend () {
	unset CFLAGS
}
