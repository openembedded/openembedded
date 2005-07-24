DESCRIPTION = "Packages that are required for the OpenSlug native build environment"
LICENSE = MIT
PR = "r3"

INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = 1
PACKAGES = "${PN}"

OPENSLUG_NATIVE = "\
	automake \
	bash \
	binutils binutils-dev \
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
	libc6 libc6-dev \
	libg2c-dev \
	libgdbm3 \
	libperl5 \
	libreadline4 libreadline-dev \
	libstdc++-dev \
	libthread-db1 \
	lrzsz \
	m4 \
	make \
	ncurses ncurses-dev ncurses-terminfo \
	patch \
	sed \
	tar \
	util-linux \
	wget \
	"

RDEPENDS = '${OPENSLUG_NATIVE}'

pkg_postinst_${PN} () {
	# Fix some strange .so-files with strange comments in them. This should
	# really be done in the packages providing these, but untill that, this
	# works, and will not break anything when it actually gets fixed
	tail -n 2 /usr/lib/libc.so > /tmp/tmpfile
	mv /tmp/tmpfile /usr/lib/libc.so
	tail -n 2 /usr/lib/libpthread.so > /tmp/tmpfile
	mv /tmp/tmpfile /usr/lib/libpthread.so
}

