DESCRIPTION = "Packages that are compatible with the OpenSlug firmware"
LICENSE = MIT
PR = "r4"

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
	gzip \
	ipkg-utils \
	libtool \
	lsof \
	m4 \
	make \
	monotone-4 monotone-5 \
	ncurses \
	openssh \
	patch \
	pciutils \
	perl \
	pkgconfig \
	quilt \
	sed \
	strace \
	tar \
	util-linux \
	"


OPENSLUG_PACKAGES = "\
	atftp \
	bash \
	bind \
	bluez-utils-nodbus \
	bridge-utils \
	bwmon \
	ccxstream \
	coreutils \
	cron \
	cvs\
	cyrus-imapd \
	db4 \
	dnsmasq \
	expat \
	ftpd-topfield \
	glib-2.0 \
	gphoto2 \
	gtk-doc \
	iperf \
	jpeg \
	less \
	libpam \
	libpng \
	libusb \
	libxml2 \
	man man-pages \
	mgetty \
	miau \ 
	microcom \
	mpd \
	mt-daapd \
	mutt \
	mysql \
	nail \
	nano \
	ncftp \
	netpbm \
	nfs-utils \
	ntp \
	obexftp openobex openobex-apps ircp \
	openldap \
	openntpd \
	openssh \
	openvpn \
	pcre \
	php \
	ppp \
	procps \
	psmisc \
	puppy \
	pwc \
	python \
	reiserfsprogs reiser4progs \
	rsync \
	samba \
	sane-backends \
	screen \
	setpwc \
	strace \
	streamripper \
	sudo \
	sysfsutils \
	thttpd \
	thttpd \
	tiff \
	timezones \
	unionfs-modules unionfs-utils \
	vlan \
	wakelan \
	wget \
	xinetd \
	yp-tools ypbind ypserv \
	zlib \
	"

BROKEN_PACKAGES = "\
	"

DEPENDS = 'openslug-image \
	${OPENSLUG_PACKAGES} \
	${OPENSLUG_DEVELOPMENT} \
	openslug-native \
	package-index'
