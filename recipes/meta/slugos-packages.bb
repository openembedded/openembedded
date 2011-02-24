# Meta package containing all the packages which build for SlugOS
#
# All packages in here must build with the slugos-???.conf distros,
# they do not necessarily work.
DESCRIPTION = "Packages that are compatible with the SlugOS firmware"
HOMEPAGE = "http://www.nslu2-linux.org"
LICENSE = "MIT"
PR = "r75"
CONFLICTS = "db3"

COMPATIBLE_MACHINE = "nslu2|ixp4xx"
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
	asterisk-core-sounds-en-alaw \
	asterisk-core-sounds-en-g729 \
	asterisk-core-sounds-en-gsm \
	asterisk-core-sounds-en-ulaw \
	asterisk-extra-sounds-en-alaw \
	asterisk-extra-sounds-en-g729 \
	asterisk-extra-sounds-en-gsm \
	asterisk-extra-sounds-en-ulaw \
	asterisk-moh-freeplay-alaw \
	asterisk-moh-freeplay-g729 \
	asterisk-moh-freeplay-gsm \
	asterisk-moh-freeplay-ulaw \
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
	bluez-libs \
	bogofilter \
	bonnie++ \
	boost \
	bridge-utils \
	bwmon \
	bzip2 \
	ccxstream \
	cdparanoia \
	cdstatus \
	cherokee \
	coreutils \
	cron \
	cryptsetup \
	curl \
	cvs \
	db \
	dbus \
	devio \
	devlabel \
	diffstat \
	diffutils \
	dircproxy \
	dnsmasq \
	dropbear \
	e2fsprogs \
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
	gphoto2 \
	grep \
	groff \
	gtk-doc \
	gzip \
	hdparm \
	hostap-daemon \
	ifupdown \
	inetutils \
	iozone3 \
	iperf \
	opkg-utils \
	iptables \
	joe \
	jpeg \
	kexec-tools \
	lcdproc \
	less \
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
	libusb1 libusb-compat \
	libvorbis \
	libxml2 \
	lighttpd \
	litestream \
	logrotate \
	lrzsz \
	lsof \
	lvm2 \
	m4 \
	madplay \
	mailx \
	make \
	man \
	man-pages \
	masqmail \
	mdadm \
	mediatomb \
	memtester \
	mgetty \
	microcom \
	minicom \
	monit \
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
	nfs-utils \
	ngrep \
	nmap \
	ntfs-3g \
	ntp \
	ntpclient \
	openntpd \
	openssh \
	openvpn \
	owfs \
	patch \
	pciutils \
	perl \
	picocom \
	pkgconfig \
	popt \
	portmap \
	ppp \
	procps \
	psmisc \
	puppy \
	python \
	quilt \
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
	spandsp \
	sqlite \
	squid \
	sshfs-fuse \
	ssmtp \
	strace \
	streamripper \
	stunnel \
	sudo \
	sysfsutils \
	syslog-ng \
	tar \
	tcpdump \
	thttpd \
	tiff \
	tzdata \
	unrar \
	unzip \
	upslug2 \
	usbutils \
	ushare \
	util-linux-ng \
	vim \
	vlan \
	vsftpd \
	w3cam \
	wakelan \
	watchdog \
	webcam-server \
	wget \
	wireless-tools \
	wpa-supplicant \
        wview-sim \
	wview-vpro \
	wview-wxt510 \
	xinetd \
	yp-tools ypbind ypserv \
	zd1211-firmware \
	zip \
	zlib \
	"

# Packages that may pull in X11 libs.  We need to consider
# if these are practical.
SLUGOS_X11_PACKAGES = "\
	bluez-hcidump \
	bluez4 \
	cups \
	gpsd \
	ircp \
	libao \
	mpd \
	netatalk \
	obexftp \
	obexpush \
	openobex-apps \
	openobex \
	rtorrent \
	sane-backends \
	task-mokogateway-everything \
	wireshark \
	"

# Packages that are broken but need to be fixed!
#
# - madwifi-ng: needs newer version for updated IXP4XX kernel
# 
SLUGOS_BROKEN_BUT_NEED_FIXING_PACKAGES = "\
	madwifi-ng \
	"

# Packages currently broken on all platforms
# Notes:
#  ctrlproxy - dependency on tdb.h (part of samba but not packaged/staged).
#
SLUGOS_BROKEN_PACKAGES = "\
	ctrlproxy \
	ctorrent \
	cyrus-imapd \
	cyrus-sasl \
	dsniff \
	eciadsl \
	gspcav1 \
	irssi \
	linphone \
	lirc-modules lirc \
	madfu \
	miau \
	motion \
	netpbm \
	openldap \
	postfix \
	pvrusb2-mci \
	pwc \
	qc-usb-messenger \
	reiserfsprogs reiser4progs \
	task-native-sdk \
	unionfs-modules unionfs-utils \
	wview-sim-mysql wview-wxt510-mysql wview-vpro-mysql \
	yeaphone \
	zd1211 \
	"

SLUGOS_EXTRA_PACKAGES ?= ""

# The package-index at the end causes regeneration of the Packages.gz and
# other control files.
DEPENDS = "\
	slugos-image \
	slugos-native \
	task-proper-tools \
	task-sdk-native \
	${SLUGOS_PACKAGES} \
	${SLUGOS_EXTRA_PACKAGES} \
	package-index \
	"

inherit meta

do_package_write_ipk() {
}
