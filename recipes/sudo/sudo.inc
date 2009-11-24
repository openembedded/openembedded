DESCRIPTION = "Sudo (superuser do) allows a system \
administrator to give certain users (or groups of \
users) the ability to run some (or all) commands \
as root while logging all commands and arguments."
LICENSE = "sudo"
HOMEPAGE = "http://www.sudo.ws/"
PRIORITY = "optional"
SECTION = "admin"

inherit autotools

EXTRA_OECONF += "--with-editor=/bin/vi --with-env-editor --with-all-insults "

do_configure_prepend () {
  # Make sure the build does not get clever.
  export sudo_cv_uid_t_len=10
  export sudo_cv_func_unsetenv_void=no

  # Prevent binaries from being stripped.
  sed -i 's/\($(INSTALL).*\) -s \(.*[(sudo|visudo)]\)/\1 \2/g' Makefile.in

  rm -f acsite.m4
  if [ ! -e acinclude.m4 ]; then
    cat aclocal.m4 > acinclude.m4
  fi
}

do_configure() { 
   oe_runconf
}

pkg_postinst() {
	if [ "x$D" != "x" ]; then
		exit 1
	fi

	chmod 4111 /usr/bin/sudo
	chmod 0440 /etc/sudoers
}
