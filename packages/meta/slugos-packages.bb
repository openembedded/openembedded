# Meta package containing all the packages which build for SlugOS
#
# All packages in here must build with the slugos-???.conf distros,
# they do not necessarily work.
DESCRIPTION = "Packages that are compatible with the SlugOS firmware"
HOMEPAGE = "http://www.nslu2-linux.org"
LICENSE = "MIT"
PR = "r44"
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
	bluez-hcidump \
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
	cryptsetup \
	ctorrent \
	ctrlproxy \
	cups \
	curl \
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
	e2fsprogs \
	e2fsprogs-libs \
	eciadsl \
	expat \
	ez-ipupdate \
	fconfig \
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
	gphoto2 \
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
	logrotate \
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
	mpd \
	mt-daapd \
	mtd-utils \
	mutt \
	mysql \
	nail \
	nano \
	ncftp \
	ncurses \
	net-tools \
	netcat \
	netpbm \
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
	portmap \
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
	sane-backends \
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
	thttpd \
	tiff \
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
        wview-sim \
	wview-vpro \
	wview-wxt510 \
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
	dsniff \
	fetchmail \
	lirc-modules lirc \
	madfu \
	openldap \
	pvrusb2-mci \
	pwc \
	qc-usb-messenger \
	syslog-ng \
	openocd task-mokogateway-everything \
	task-native-sdk \
	unionfs-modules unionfs-utils \
	wview-sim-mysql wview-wxt510-mysql wview-vpro-mysql \
	zd1211 \
	"

SLUGOS_EXTRA_PACKAGES ?= ""

# The package-index at the end causes regeneration of the Packages.gz and
# other control files.
DEPENDS = "\
	slugos-image \
	slugos-native \
	task-nas-server-everything \
	task-proper-tools \
	${SLUGOS_PACKAGES} \
	${SLUGOS_EXTRA_PACKAGES} \
	package-index \
	"

inherit meta

do_package_write_ipk() {
}
