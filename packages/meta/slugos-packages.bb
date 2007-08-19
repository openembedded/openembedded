# Meta package containing all the packages which build for SlugOS
#
# All packages in here must build with the slugos-???.conf distros,
# they do not necessarily work.
DESCRIPTION = "Packages that are compatible with the SlugOS firmware"
HOMEPAGE = "http://www.nslu2-linux.org"
LICENSE = "MIT"
PR = "r34"
CONFLICTS = "db3"

COMPATIBLE_MACHINE = "nslu2"
EXCLUDE_FROM_WORLD = "1"
INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = "1"

# The list of packages to build for the slugos DISTRO.
# KEEP IN ALPHABETICAL ORDER
# Do *not* simply comment out a line. That will break. Instead
# remove the package and place it in the corresponding "broken" list

SLUGOS_PACKAGES = "\
	alsa-lib \
	alsa-utils \
	apex-env \
	apr \
	asterisk \
	asterisk-sounds \
	atftp \
	audiofile \
	aumix \
	autoconf \
	autofs \
	automake \
	bash \
	beep \
	bind \
	binutils \
	bison \
	bluez-utils \
	bogofilter \
	boost \
	bridge-utils \
	bzip2 \
	ccxstream \
	cdparanoia \
	cdstatus \
	cherokee \
	coreutils \
	cron \
	ctorrent \
	cvs \
	cyrus-imapd \
	cyrus-sasl \
	db \
	devio \
	devlabel \
	diffstat \
	diffutils \
	dircproxy \
	dnsmasq \
	dsniff \
	e2fsprogs \
	e2fsprogs-libs \
	eciadsl \
	expat \
	ez-ipupdate \
	fconfig \
	fetchmail \
	file \
	findutils \
	fis \
	flac \
	flex \
	flite \
	ftpd-topfield \
	fuse \
	gawk \
	gcc \
	gdb \
	gdbm \
	glib-2.0 \
	gnu-config \
	grep \
	groff \
	gspcav1 \
	gtk-doc \
	gzip \
	hdparm \
	ifupdown \
	iperf \
	ipkg-utils \
	iptables \
	ircp \
	irssi \
	joe \
	jpeg \
	lcdproc \
	less \
	libao \
	libdvb \
	libexif \
	libid3tag \
	liblockfile \
	libmad \
	libmikmod \
	libogg \
	libol \
	libpam \
	libpcre \
	libpng \
	libtool \
	libupnp \
	libusb \
	libvorbis \
	libxml2 \
	linphone \
	litestream \
	lrzsz \
	lsof \
	lvm2 \
	m4 \
	madplay \
	madwifi-ng \
	mailx \
	make \
	man man-pages \
	masqmail \
	mdadm \
	mediatomb \
	memtester \
	mgetty \
	miau \
	microcom \
	minicom \
	motion \
	mt-daapd \
	mtd-utils \
	mutt \
	nail \
	nano \
	ncftp \
	ncurses \
	netcat \
	nfs-utils \
	nmap \
	ntfs-3g \
	ntp \
	ntpclient \
	obexftp \
	obexpush \
	openobex-apps \
	openntpd \
	openobex \
	openssh \
	openvpn \
	patch \
	pciutils \
	perl \
	picocom \
	pkgconfig \
	popt \
	postfix \
	ppp \
	procps \
	psmisc \
	puppy \
	python \
	quilt \
	reiserfsprogs reiser4progs \
	rng-tools \
	rsync \
	samba \
	screen \
	sed \
	setpwc \
	setserial \
	sipsak \
	slugimage \
	smartmontools \
	ssmtp \
	strace \
	streamripper \
	sudo \
	sysfsutils \
	tar \
	task-mokogateway-everything \
	thttpd \
	tiff \
	timezones \
	tzdata \
	unzip \
	upslug2 \
	usbutils \
	ushare \
	util-linux \
	vim \
	vlan \
	vsftpd \
	w3cam \
	wakelan \
	watchdog \
	webcam-server \
	wget \
	wireless-tools \
	wireshark \
	wpa-supplicant \
        wview-sim wview-vpro wview-wxt510 \
	xinetd \
	yeaphone \
	yp-tools ypbind ypserv \
	zd1211-firmware \
	zip \
	zlib \
	"

# Packages currently broken on all platforms
SLUGOS_BROKEN_PACKAGES = "\
	bwmon \
	ctrlproxy \
	libgphoto2 gphoto2 \
	logrotate \
	madfu \
	openldap \
	\
	mpd \
	netpbm \
	pvrusb2-mci \
	qc-usb-messenger \
	syslog-ng \
	sane-backends \
	unionfs-modules \
	unionfs-utils \
	lirc \
	pwc \
	task-native-sdk \
	zd1211 \
	mysql \
        wview-sim-mysql wview-vpro-mysql \
        wview-wxt510-mysql \
	"

SLUGOS_EXTRA_PACKAGES ?= ""

# The package-index at the end causes regeneration of the Packages.gz and
# other control files.
DEPENDS = "\
	slugos-image \
	slugos-native \
	${SLUGOS_PACKAGES} \
	${SLUGOS_EXTRA_PACKAGES} \
	package-index \
	"
