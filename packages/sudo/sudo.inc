SECTION = "base"
DESCRIPTION = "Sudo (superuser do) allows a system \
administrator to give certain users (or groups of \
users) the ability to run some (or all) commands \
as root while logging all commands and arguments."
LICENSE = "sudo"
HOMEPAGE = "http://www.courtesan.com/sudo/"
PRIORITY = "optional"
SECTION = "admin"

inherit autotools

EXTRA_OECONF = "--with-env-editor"

do_configure_prepend () {
	rm -f acsite.m4
	if [ ! -e acinclude.m4 ]; then
		cat aclocal.m4 > acinclude.m4
	fi
}
