# Meta package containing all the packages which build for SlugOS
#
# All packages in here must build with the slugos-???.conf distros,
# they do not necessarily work.
DESCRIPTION = "Packages that are compatible with the Openprotium on the iomega Storcenter"
HOMEPAGE = "http://www.openprotium.org"
LICENSE = "MIT"
PR = "r4"
CONFLICTS = "db3"
PROVIDES += "${OPENPROTIUM_IMAGENAME}-packages"

EXCLUDE_FROM_WORLD = "1"
INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = "1"

inherit meta

# The list of packages to build for the slugos DISTRO.
# KEEP IN ALPHABETICAL ORDER
# Do *not* simply comment out a line. That will break. Instead
# remove the package and place it in the corresponding "broken" list

# deleted from "base" as they don't immediately build...
#	asterisk \
#	asterisk-sounds \
#	beep \
#	cherokee \
#	cyrus-sasl \
#	atftp \
#	flac \
#	gphoto2 \
#	gdb \
#	lirc \
#	masqmail \
#	wakelan \
#	wireless-tools \
#	wpa-supplicant \
#	openldap \
#	bluez-utils-nodbus \
#	lcdproc \
#	libxml2 \
#	libdvb \
#	madwifi-ng \
#	motion \
#	ftpd-topfield \
#	eciadsl \
#	netpbm \
#	reiserfsprogs reiser4progs \
#	libgphoto2 \
#	python \
#	mpd \
#	memtester \
#	puppy \
#	samba \
#	sane-backends \
#	vsftpd \
#	syslog-ng \
#	zd1211 \
#	cdparanoia \
#	litestream \
#	pvrusb2-mci \
#	pwc \
#	fetchmail \

OPENPROTIUM_PACKAGES = "\
	alsa-lib \
	alsa-utils \
	apache2 \
	audiofile \
	aumix \
	autoconf \
	automake \
	bash \
	bind \
	binutils \
	bison \
	bridge-utils \
	bzip2 \
	ccxstream \
	cdstatus \
	coreutils \
	cron \
	ctorrent \
	cvs \
	db \
	devlabel \
	diffstat \
	diffutils \
	dnsmasq \
	e2fsprogs \
	e2fsprogs-libs \
	expat \
	ez-ipupdate \
	file \
	findutils \
	flex \
	flite \
	gallery \
	gawk \
	gcc \
	gdbm \
	glib-2.0 \
	gnu-config \
	grep \
	gtk-doc \
	gzip \
	hdparm \
	ifupdown \
	ipkg-utils \
	iptables \
	ircp \
	joe \
	jpeg \
	libao \
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
	lrzsz \
	lsof \
	lvm2 \
	m4 \
	madplay \
	mailx \
	make \
	mdadm \
	mgetty \
	miau \
	microcom \
	minicom \
	modphp \
	mt-daapd \
	mtd-utils \
	mutt \
	nail \
	nano \
	ncftp \
	ncurses \
	netcat \
	nmap \
	ntp \
	openobex-apps \
	openntpd \
	openobex \
	openssh \
	openvpn \
	patch \
	pciutils \
	libpcre \
	perl \
	pkgconfig \
	ppp \
	procps \
	quilt \
	rng-tools \
	rsync \
	sed \
	setpwc \
	setserial \
	smartmontools \
	ssmtp \
	strace \
	streamripper \
	sysfsutils \
	tar \
	thttpd \
	tiff \
	unzip \
	usbutils \
	util-linux \
	vim \
	vlan \
	wget \
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
	icecast \
	cyrus-imapd \
	"

# These packages will never build because uclibc lacks (and always will lack)
# appropriate support.  This define is for documentation of this fact!  The
# normal cause is that the package uses the "NIS" interfaces (once known as
# YP - a trademark of BT which SUN used without license - the missing function
# calls often still have 'yp' in the name).

# NOTE: rng-tools is only here until argp-standalone can be built!
UCLIBC_UNSUPPORTABLE_PACKAGES = "\
	libpam \
	nfs-utils \
	rng-tools \
	postfix \
	yp-tools ypbind ypserv \
	"

# These packages work with glibc, but break on uclibc.
UCLIBC_BROKEN_PACKAGES = "\
	apr \
	bogofilter \
	boost \
	bwmon \
	erlang \
	linphone \
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
	tzdata \
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

#
# you can place these in the top level openembedded/conf/distro/openprotium.conf
# file to fine-tune what's happening
#
OPENPROTIUM_EXTRA_PACKAGES ?= ""

# The package-index at the end causes regeneration of the Packages.gz and
# other control files.
# openprotium-native \
DEPENDS = "\
	openprotium-image \
	${OPENPROTIUM_PACKAGES} \
	${OPENPROTIUM_EXTRA_PACKAGES} \
	package-index \
	"
