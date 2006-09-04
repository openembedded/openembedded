# Meta package containing all the packages which build for SlugOS
#
# All packages in here must build with the slugos-???.conf distros,
# they do not necessarily work.
DESCRIPTION = "Packages that are compatible with the SlugOS firmware"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
HOMEPAGE = "http://www.nslu2-linux.org"
LICENSE = "MIT"
PR = "r12"
CONFLICTS = "db3"
PROVIDES += "${SLUGOS_IMAGENAME}-packages"

EXCLUDE_FROM_WORLD = "1"
INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = 1

# The list of packages to build for the slugos DISTRO.
# KEEP IN ALPHABETICAL ORDER
SLUGOS_PACKAGES = "\
	alsa-lib \
	alsa-utils \
	asterisk \
	asterisk-sounds \
	atftp \
	audiofile \
	aumix \
	autoconf \
	automake \
	bash \
	beep \
	bind \
	binutils \
	bison \
	bluez-libs \
	bluez-utils-nodbus \
	bridge-utils \
	bwmon \
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
	devlabel \
	diffstat \
	diffutils \
	dnsmasq \
	e2fsprogs \
	e2fsprogs-libs \
	eciadsl \
	expat \
	ez-ipupdate \
	fetchmail \
	file \
	findutils \
	flac \
	flex \
	flite \
	ftpd-topfield \
	gawk \
	gcc \
	gdb \
	gdbm \
	glib-2.0 \
	gnu-config \
	gphoto2 \
	grep \
	gtk-doc \
	gzip \
	hdparm \
	icecast \
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
	libgphoto2 \
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
	lirc \
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
	mpd \
	mt-daapd \
	mtd-utils \
	mutt \
	nail \
	nano \
	ncftp \
	ncurses \
	netcat \
	netpbm \
	nmap \
	ntp \
	openobex-apps \
	openldap \
	openntpd \
	openobex \
	openssh \
	openvpn \
	patch \
	pciutils \
	pcre \
	perl \
	pkgconfig \
	ppp \
	procps \
	puppy \
	pvrusb2-mci \
	pwc \
	python \
	quilt \
	reiserfsprogs reiser4progs \
	rsync \
	samba \
	sane-backends \
	sed \
	setpwc \
	setserial \
	smartmontools \
	ssmtp \
	strace \
	streamripper \
	sysfsutils \
	syslog-ng \
	tar \
	thttpd \
	tiff \
	unzip \
	usbutils \
	ushare \
	util-linux \
	vim \
	vlan \
	vsftpd \
	wakelan \
	watchdog \
	wget \
	wireless-tools \
	wpa-supplicant \
	zd1211 \
	zip \
	zlib \
	"

# Packages currently broken on all platforms
SLUGOS_BROKEN_PACKAGES = "\
	irssi \
	obexftp \
	qc-usb-messenger \
	unionfs-modules \
	unionfs-utils \
	"

# These packages will never build because uclibc lacks (and always will lack)
# appropriate support.  This define is for documentation of this fact!  The
# normal cause is that the package uses the "NIS" interfaces (once known as
# YP - a trademark of BT which SUN used without license - the missing function
# calls often still have 'yp' in the name).
UCLIBC_UNSUPPORTABLE_PACKAGES = "\
	libpam \
	nfs-utils \
	postfix \
	yp-tools ypbind ypserv \
	"

# These packages work with glibc, but break on uclibc.
UCLIBC_BROKEN_PACKAGES = "\
	apr \
	bogofilter \
	boost \
	linphone \
	sudo \
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
        wview-sim-mysql wview-vpro-mysql \
        wview-wxt510-mysql \
	xinetd \
	"

SLUGOS_PACKAGES_append_linux-uclibc = "\
	"

# These packages are not in the build because they have a significant compilation
# time, add them to SLUGOS_EXTRA_PACKAGES if required
SLUGOS_OPTIONAL_PACKAGES = "\
	mysql \
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
