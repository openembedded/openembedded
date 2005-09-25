DESCRIPTION = "Packages that are compatible with the OpenSlug firmware"
LICENSE = MIT
PR = "r7"

INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = 1
PACKAGES = "${PN}"

OPENSLUG_PACKAGES = "\
	alsa-lib \
	alsa-utils \
	atftp \
	autoconf \
	automake \
	aumix \
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
	file \
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
	ifupdown \
	iperf \
	ipkg-utils \
	iptables \
	irssi \
	joe \
	jpeg \
	lcdproc \
	less \
	libdvb \
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
	pvrusb2-mci \
	pwc \
	python \
	qc-usb-messenger \
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
	syslog-ng \
	tar \
	thttpd \
	tiff \
	timezones \
	unionfs-modules unionfs-utils \
	usbutils \
	util-linux \
	vim \
	vlan \
	vsftpd \
	wakelan \
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
	watchdog \
	"

DEPENDS = 'openslug-image \
	${OPENSLUG_PACKAGES} \
	openslug-native \
	package-index'
