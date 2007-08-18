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
	gspcav1 \
	gtk-doc \
	gzip \
	hdparm \
	ifupdown \
	ipkg-utils \
	iptables \
	ircp \
	joe \
	jpeg \
	lcdproc \
	less \
	libao \
	libdvb \
	libid3tag \
	liblockfile \
	libmad \
	libmikmod \
	libogg \
	libol \
	libpng \
	libtool \
	libupnp \
	libusb \
	libvorbis \
	libxml2 \
	litestream \
	lrzsz \
	lsof \
	lvm2 \
	m4 \
	madplay \
	madwifi-ng \
	mailx \
	make \
	masqmail \
	mdadm \
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
	openldap \
	openntpd \
	openobex \
	openssh \
	openvpn \
	patch \
	pciutils \
	libpcre \
	perl \
	picocom \
	pkgconfig \
	ppp \
	procps \
	puppy \
	python \
	quilt \
	reiserfsprogs reiser4progs \
	rng-tools \
	rsync \
	samba \
	sed \
	setpwc \
	setserial \
	sipsak \
	slugimage \
	smartmontools \
	ssmtp \
	strace \
	streamripper \
	sysfsutils \
	tar \
	task-mokogateway-everything \
	thttpd \
	tiff \
	tzdata \
	unzip \
	upslug2 \
	usbutils \
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
	zd1211-firmware \
	zip \
	zlib \
	"

# Packages currently broken on all platforms
SLUGOS_BROKEN_PACKAGES = "\
	bwmon \
	gphoto2 \
	irssi \
	libgphoto2 \
	logrotate \
	madfu \
	mediatomb \
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

# These packages will never build because uclibc lacks (and always will lack)
# appropriate support.  This define is for documentation of this fact!  The
# normal cause is that the package uses the "NIS" interfaces (once known as
# YP - a trademark of BT which SUN used without license - the missing function
# calls often still have 'yp' in the name).

# NOTE: rng-tools is only here until argp-standalone can be built!
#	nfs-utils \

UCLIBC_UNSUPPORTABLE_PACKAGES = "\
	libpam \
	rng-tools \
	postfix \
	yp-tools ypbind ypserv \
	"

# These packages work with glibc, but break on uclibc.
#	erlang \

UCLIBC_BROKEN_PACKAGES = "\
	apr \
	bogofilter \
	boost \
	linphone \
	yeaphone \
	sudo \
	ushare \
	"

# Packages which build only with glibc (some of these use internal
# glibc functions and so will probably never run on uclibc).
SLUGOS_PACKAGES_append_linux = "\
	${UCLIBC_UNSUPPORTABLE_PACKAGES} \
	${UCLIBC_BROKEN_PACKAGES} \
	ctrlproxy \
	dsniff \
	iperf \
	groff \
	man man-pages \
	psmisc \
	screen \
	timezones \
        wview-sim wview-vpro wview-wxt510 \
	xinetd \
	"

SLUGOS_PACKAGES_append_linux-uclibc = "\
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
