DESCRIPTION = "An sh-compatible command language interpreter."
HOMEPAGE = "http://cnswww.cns.cwru.edu/~chet/bash/bashtop.html"
DEPENDS = "ncurses"
PROVIDES = "virtual/sh"
SECTION = "base/shell"
LICENSE = "GPL"
PR = "r4"

SRC_URI = "${GNU_MIRROR}/bash/bash-${PV}.tar.gz \
           file://bashbug-editor.patch;patch=1;pnum=0 \
           file://deb-bash-config.patch;patch=1 \
           file://deb-examples.patch;patch=1;pnum=0 \
           file://man-arithmetic.patch;patch=1;pnum=0 \
           file://man-fignore.patch;patch=1;pnum=0 \
           file://man-bashrc.patch;patch=1 \
           file://privmode.patch;patch=1 \
           file://various.patch;patch=1 \
           file://report-155436.patch;patch=1;pnum=0 \
           file://bash205b-001.patch;patch=1;pnum=0 \
           file://bash205b-002.patch;patch=1;pnum=0 \
           file://bash205b-003.patch;patch=1;pnum=0 \
           file://bash205b-004.patch;patch=1;pnum=0 \
           file://bash205b-005.patch;patch=1;pnum=0 \
           file://bash205b-006.patch;patch=1;pnum=0 \
           file://bash205b-007.patch;patch=1;pnum=0 \
           file://rl-examples.patch;patch=1;pnum=0 \
           file://rl-inputrc.patch;patch=1 \
           file://rl-del-backspace-policy.patch;patch=1;pnum=0 \
           file://rl-8bit-init.patch;patch=1 \
           file://rl-slow-multibyte.patch;patch=1 \
           file://s390-build.patch;patch=1;pnum=0 \
           file://rbash-manpage.patch;patch=1;pnum=0 \
           file://rbash-login-shell.patch;patch=1 \
           file://execute-cmd.patch;patch=1 \
           file://builtins-shift.patch;patch=1;pnum=0 \
           file://suspend-segfault.patch;patch=1 \
           file://mailcheck.patch;patch=1 \
           file://autofoo.patch;patch=1 \
           file://gcc34.patch;patch=1 \
           file://signames-mipsel.diff;patch=1"

inherit autotools

bindir = "/bin"
sbindir = "/sbin"

EXTRA_OECONF = "--with-curses"
BUILD_CPPFLAGS_append = " -I${S} -I${S}/include"
BUILD_CFLAGS_append = " -I${S} -I${S}/include"
export CFLAGS_FOR_BUILD = "${BUILD_CFLAGS}"
export CPPFLAGS_FOR_BUILD = "${BUILD_CPPFLAGS}"
export LDFLAGS_FOR_BUILD = "${BUILD_LDFLAGS}"
export CC_FOR_BUILD = "${BUILD_CC}"

do_configure () {
	if [ ! -e acinclude.m4 ]; then
		mv aclocal.m4 acinclude.m4
	fi
	autotools_do_configure
}

# dont use update-alternatives class because since we are dealing with /bin/sh
# we need to do the remove in pkg_prerm where the /bin/sh link still points
# to something (postrm is a shell script)

ALTERNATIVE_NAME = "sh"
ALTERNATIVE_PATH = "${bindir}/bash"
ALTERNATIVE_PRIORITY = "30"
ALTERNATIVE_LINK = "${bindir}/${ALTERNATIVE_NAME}"

pkg_postinst() {
update-alternatives --install ${ALTERNATIVE_LINK} ${ALTERNATIVE_NAME} ${ALTERNATIVE_PATH} ${ALTERNATIVE_PRIORITY}
}

pkg_prerm() {
update-alternatives --remove ${ALTERNATIVE_NAME} ${ALTERNATIVE_PATH}
}
