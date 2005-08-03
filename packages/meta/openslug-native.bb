DESCRIPTION = "Packages that are required for the OpenSlug native build environment"
LICENSE = MIT
PR = "r10"

INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = 1
PACKAGES = "${PN}"

OPENSLUG_NATIVE = "\
	autoconf \
	automake \
	bash \
	binutils binutils-dev binutils-symlinks \
	bison \
	bzip2 \
	coreutils \
	cpp cpp-symlinks \
	cvs \
	flex \
	gawk \
	g++ g++-symlinks \
	gcc gcc-symlinks \
	glibc-extra-nss glibc-utils \
	gnu-config \
	gzip \
	libc6 libc6-dev \
	libg2c-dev \
	libgdbm3 \
	libperl5 \
	libreadline4 libreadline-dev \
	libstdc++-dev \
	libthread-db1 \
	libtool \
	lrzsz \
	m4 \
	make \
	monotone-5 \
	ncurses ncurses-dev ncurses-terminfo \
	patch \
	perl perl-modules \
	pkgconfig \
	python-core python-crypt python-io python-lang python-pickle python-shell python-textutils \
	quilt \
	sed \
	tar \
	util-linux \
	wget \
	"

RDEPENDS = '${OPENSLUG_NATIVE}'

