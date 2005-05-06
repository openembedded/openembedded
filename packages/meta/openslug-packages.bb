DESCRIPTION = "Packages that are compatible with the OpenSlug firmware"
LICENSE = MIT
PR = "r3"

ALLOW_EMPTY = 1
PACKAGES = "${PN}"

OPENSLUG_DEVELOPMENT = "\
	autoconf \
	automake \
	bash \
	bison \
	bzip2 \
	coreutils \
	cvs \
	diffutils \
	findutils \
	flex \
	gawk \
	gcc \
	gdb \
	grep \
	lsof \
	m4 \
	make \
	ncurses \
	openssh \
	pciutils \
	quilt \
	sed \
	"

# These packages only build on TARGET_OS=linux, not
# TARGET_OS=linux-uclibc
OPENSLUG_DEVELOPMENT_append_linux = "\
	perl \
	tar \
	"


OPENSLUG_PACKAGES = "\
	atftp \
	bash \
	bluez-utils-nodbus bridge-utils \
	coreutils cvs\
	expat \
	miau microcom mt-daapd mysql \
	nail \
	openssh \
	ppp puppy pwc \
	rsync \
	sudo sysfsutils \
	thttpd \
	db4 \
	openldap \
	ntp \
	"

# These packages only build on TARGET_OS=linux, not
# TARGET_OS=linux-uclibc
OPENSLUG_PACKAGES_append_linux = "\
	php \
	yp-tools ypbind ypserv \
	"

BROKEN_PACKAGES = "\
	mgetty \
	strace  \
	"

DEPENDS = 'openslug-image \
	${OPENSLUG_PACKAGES} \
	${OPENSLUG_DEVELOPMENT}'
