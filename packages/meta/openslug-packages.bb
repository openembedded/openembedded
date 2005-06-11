DESCRIPTION = "Packages that are compatible with the OpenSlug firmware"
LICENSE = MIT
PR = "r3"

INHIBIT_DEFAULT_DEPS = "1"
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
	dnsmasq \
	expat \
	ftpd-topfield \
	less libusb \
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
	reiserfsprogs reiser4progs \
	python \
	samba \
	strace \
	wget \
	"

# These packages only build on TARGET_OS=linux, not
# TARGET_OS=linux-uclibc
OPENSLUG_PACKAGES_append_linux = "\
	php \
	libpam \
	yp-tools ypbind ypserv \
	nfs-utils \
	"
BROKEN_PACKAGES = "\
	cron \
	mgetty \
	"

DEPENDS = 'openslug-image \
	${OPENSLUG_PACKAGES} \
	${OPENSLUG_DEVELOPMENT} \
	package-index'
