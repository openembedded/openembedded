# Meta package containing all the packages which build for SlugOS
#
# All packages in here must build with the slugos-???.conf distros,
# they do not necessarily work.
DESCRIPTION = "Packages that are compatible with the SlugOS firmware"
HOMEPAGE = "http://www.nslu2-linux.org"
LICENSE = "MIT"
PR = "r65"
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
	bluez-hcidump \
	bluez4 \
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
	cups \
	curl \
	cvs \
	db \
	devio \
	devlabel \
	diffstat \
	diffutils \
	dircproxy \
	dnsmasq \
	dropbear \
	e2fsprogs \
	e2fsprogs-libs \
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
	gpsd \
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
	ipkg-utils \
	iptables \
	ircp \
	joe \
	jpeg \
	kexec-tools \
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
	monit \
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
	netatalk \
	netcat \
	netpbm \
	nfs-utils \
	ngrep \
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
	reiserfsprogs reiser4progs \
	rng-tools \
	rsync \
	rtorrent \
	samba \
	sane-backends \
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
	task-mokogateway-everything \
	tcpdump \
	thttpd \
	tiff \
	tzdata \
	unrar \
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
	yp-tools ypbind ypserv \
	zd1211-firmware \
	zip \
	zlib \
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
	motion \
	openldap \
	postfix \
	pvrusb2-mci \
	pwc \
	qc-usb-messenger \
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
	${SLUGOS_PACKAGES} \
	${SLUGOS_EXTRA_PACKAGES} \
	package-index \
	"

inherit meta

do_package_write_ipk() {
}
