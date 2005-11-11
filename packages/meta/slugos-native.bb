# SlugOS native build tools
#
# For the most part these are generic tools which should work for any
# SlugOS variant, however there is a dependency on the libc implementation
#
DESCRIPTION = "Packages that are required for the SlugOS native build environment"
LICENSE = "MIT"
PR = "r0"

INHIBIT_DEFAULT_DEPS = "1"
EXCLUDE_FROM_WORLD = "1"
ALLOW_EMPTY = "1"
PACKAGES = "${PN}"
PROVIDES += "${SLUGOS_IMAGENAME}-native"

# Run-time only (RDEPENDS) stuff - no package explicitly provides
# these targets.
SLUGOS_NATIVE_RT_prepend_linux = "\
	glibc-extra-nss glibc-utils \
	libc6 libc6-dev \
	"
SLUGOS_NATIVE_RT_prepend_linux-uclibc = "\
	uclibc-dev uclibc-utils \
	"
SLUGOS_NATIVE_RT = "\
	binutils-dev binutils-symlinks \
	cpp cpp-symlinks \
	g++ g++-symlinks \
	gcc-symlinks \
	libg2c-dev \
	libgdbm3 \
	libperl5 \
	libreadline4 libreadline-dev \
	libstdc++-dev \
	libthread-db1 \
	ncurses-dev ncurses-terminfo \
	perl-modules \
	python-core python-crypt python-io python-lang python-pickle python-shell python-textutils \
	"

# Run-time and DEPENDS
SLUGOS_NATIVE_prepend_linux = "\
	"
SLUGOS_NATIVE_prepend_linux-uclibc = "\
	libiconv \
	uclibc \
	"
SLUGOS_NATIVE = "\
	autoconf \
	automake \
	bash \
	binutils \
	bison \
	bzip2 \
	coreutils \
	cvs \
	diffstat \
	file \
	flex \
	gawk \
	gcc \
	gnu-config \
	gzip \
	libtool \
	lrzsz \
	m4 \
	make \
	ncurses \
	patch \
	perl \
	pkgconfig \
	python-core \
	quilt \
	sed \
	tar \
	util-linux \
	wget \
	${SLUGOS_NATIVE_THUMB_BROKEN} \
	"

# If a tool won't build *on thumb libc* add it to the following list.
# Normally such a tool should be built with the ARM instruction set
# even on a thumb system (and this can be set in the tool's .bb file),
# however even this doesn't work for very large programs at present
# (only monotone!)
SLUGOS_NATIVE_THUMB_BROKEN = "\
	monotone-5 \
	"

SLUGOS_NATIVE_THUMB_BROKEN_thumb = ""

# These things are required but are not valid RDEPENDS
SLUGOS_NATIVE_DP = "\
	gdbm \
	"

RDEPENDS = '${SLUGOS_NATIVE_RT} ${SLUGOS_NATIVE}'
DEPENDS  = '${SLUGOS_NATIVE_DP} ${SLUGOS_NATIVE}'
