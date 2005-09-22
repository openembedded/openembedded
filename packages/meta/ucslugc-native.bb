DESCRIPTION = "Packages that are required for the UcSlugC native build environment"
LICENSE = MIT
PR = "r0"

INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = 1
PACKAGES = "${PN}"

# Run-time only (RDEPENDS) stuff - no package explicitly provides
# these targets.
UCSLUGC_NATIVE_RT_prepend_linux = "\
	glibc-utils \
	libc6-dev \
	"
UCSLUGC_NATIVE_RT_prepend_linux-uclibc = "\
	uclibc-dev uclibc-utils \
	"
UCSLUGC_NATIVE_RT = "\
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
	python-crypt python-io python-lang python-pickle python-shell python-textutils \
	"

# Run-time and DEPENDS
UCSLUGC_NATIVE_prepend_linux = "\
	glibc-extra-nss \
	libc6 \
	"
UCSLUGC_NATIVE_prepend_linux-uclibc = "\
	libiconv \
	uclibc \
	"
UCSLUGC_NATIVE = "\
	autoconf \
	automake \
	bash \
	binutils \
	bison \
	bzip2 \
	coreutils \
	cvs \
	diffstat \
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
	"

UCSLUGC_NATIVE_THUMB_BROKEN = "\
	monotone-5 \
	"

# These things are required but are not valid RDEPENDS
UCSLUGC_NATIVE_DP = "\
	gdbm \
	"

RDEPENDS = '${UCSLUGC_NATIVE_RT} ${UCSLUGC_NATIVE}'
DEPENDS  = '${UCSLUGC_NATIVE_DP} ${UCSLUGC_NATIVE}'
