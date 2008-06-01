require eglibc_${PV}.bb
require eglibc-intermediate.inc

# gcc uses -Werror which break on a "you have no thumb interwork" _warning_
do_configure_prepend() {
	find ${S} -name "configure" | xargs touch
	sed -i s:-Werror:: ${S}/configure
}
