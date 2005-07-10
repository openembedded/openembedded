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
	binutils \
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
	gnu-config \
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
	bash \
	bluez-utils-nodbus bridge-utils \
	coreutils cron \
	cvs\
	dnsmasq \
	expat \
	ftpd-topfield \
	gphoto2 \
	less libusb \
	miau microcom mt-daapd mysql \
	nail \
	openssh \
	openvpn \
	ppp puppy pwc \
	rsync \
	sudo sysfsutils \
	thttpd \
	db4 \
	openldap \
	openntpd \
	ntp \
	reiserfsprogs reiser4progs \
	python \
	samba \
	sane-backends \
	wget \
	unionfs-modules unionfs-utils \
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
	atftp \
	strace \
	mgetty \
	"

DEPENDS = 'openslug-image \
	${OPENSLUG_PACKAGES} \
	${OPENSLUG_DEVELOPMENT} \
	package-index'
