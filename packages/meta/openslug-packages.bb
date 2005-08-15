DESCRIPTION = "Packages that are compatible with the OpenSlug firmware"
LICENSE = MIT
PR = "r5"

INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = 1
PACKAGES = "${PN}"

OPENSLUG_PACKAGES = "\
	atftp \
	autoconf \
	automake \
	bash \
	bind \
	binutils \
	bison \
	bluez-utils-nodbus \
	bridge-utils \
	bwmon \
	bzip2 \
	ccxstream \
	coreutils \
	cron \
	ctorrent \
	ctrlproxy \
	cvs\
	cyrus-imapd \
	db4 \
	diffstat \
	diffutils \
	dnsmasq \
	expat \
	findutils \
	flex \
	ftpd-topfield \
	gawk \
	gcc \
	gdb \
	glib-2.0 \
	gnu-config \
	gphoto2 \
	grep \
	gtk-doc \
	gzip \
	iperf \
	ipkg-utils \
	iptables \
	joe \
	jpeg \
	less \
	libpam \
	libpng \
	libtool \
	libusb \
	libxml2 \
	lsof \
	m4 \
	mailx \
	make \
	man man-pages \
	mgetty \
	miau \ 
	microcom \
	monotone-5 \
	mpd \
	mt-daapd \
	mutt \
	mysql \
	nail \
	nano \
	ncftp \
	ncurses \
	netpbm \
	nfs-utils \
	ntp \
	obexftp openobex openobex-apps ircp \
	openldap \
	openntpd \
	openssh \
	openvpn \
	patch \
	pciutils \
	pcre \
	perl \
	php \
	pkgconfig \
	postfix \
	ppp \
	procps \
	psmisc \
	puppy \
	pwc \
	python \
	quilt \
	reiserfsprogs reiser4progs \
	rsync \
	samba \
	sane-backends \
	screen \
	sed \
	setpwc \
	ssmtp \
	strace \
	streamripper \
	sudo \
	sysfsutils \
	tar \
	thttpd \
	tiff \
	timezones \
	unionfs-modules unionfs-utils \
	usbutils \
	util-linux \
	vlan \
	vsftpd \
	wakelan \
	watchdog \
	wireless-tools \
	wget \
	xinetd \
	yp-tools ypbind ypserv \
	zd1211 \
	zlib \
	"

BROKEN_PACKAGES = "\
	groff \
	icecast \
	"

DEPENDS = 'openslug-image \
	${OPENSLUG_PACKAGES} \
	openslug-native \
	package-index'
