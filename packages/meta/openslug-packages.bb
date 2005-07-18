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
	monotone-4 monotone-5 \
	ncurses \
	openssh \
	patch \
	pciutils \
	quilt \
	sed \
	util-linux \
	"

# These packages only build on TARGET_OS=linux, not
# TARGET_OS=linux-uclibc
OPENSLUG_DEVELOPMENT_append_linux = "\
	perl \
	tar \
	"


OPENSLUG_PACKAGES = "\
	bash \
	bluez-utils-nodbus \
	bridge-utils \
	coreutils \
	cron \
	cvs\
	dnsmasq \
	expat \
	ftpd-topfield \
	glib-2.0 \
	gphoto2 \
	gtk-doc \
	less \
	libusb \
	libxml2 \
	miau \ 
	microcom \
	mt-daapd \
	mutt \
	mysql \
	nail \
	openssh \
	openvpn \
	pcre \
	ppp \
	puppy \
	pwc \
	rsync \
	sudo \
	sysfsutils \
	thttpd \
	db4 \
	openldap \
	openntpd \
	ntp \
	reiserfsprogs reiser4progs \
	python \
	samba \
	sane-backends \
	thttpd \
	vlan \
	wget \
	unionfs-modules unionfs-utils \
	"

# These packages only build on TARGET_OS=linux, not
# TARGET_OS=linux-uclibc  (Note that for several this
# is because of use of single precision FP interfaces
# such as sinf.)
OPENSLUG_PACKAGES_append_linux = "\
	bind \
	mgetty \
	mpd \
	nfs-utils \
	libpam \
	php \
	postfix \
	xinetd \
	yp-tools ypbind ypserv \
	"

BROKEN_PACKAGES = "\
	atftp \
	strace \
	"

DEPENDS = 'openslug-image \
	${OPENSLUG_PACKAGES} \
	${OPENSLUG_DEVELOPMENT} \
	package-index'
