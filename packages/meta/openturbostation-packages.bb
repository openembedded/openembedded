# Meta package containing all the packages which build for SlugOS
#
# All packages in here must build with the slugos-???.conf distros,
# they do not necessarily work.
DESCRIPTION = "Packages that are compatible with the Openprotium on the iomega Storcenter"
HOMEPAGE = "http://www.openprotium.org"
LICENSE = "MIT"
PR = "r1"
CONFLICTS = "db3"
PROVIDES += "${OPENTURBOSTATION_IMAGENAME}-packages"

EXCLUDE_FROM_WORLD = "1"
INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = "1"

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
#	glib-2.0 \
#	lirc \
#	masqmail \
#	wakelan \
#	wireless-tools \
#	wpa-supplicant \
#	bluez-utils-nodbus \
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
#	zd1211 \

OPENTURBOSTATION_PACKAGES = "\
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
	cdparanoia \
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
	fetchmail \
	file \
	findutils \
	flex \
	flite \
	gallery \
	gawk \
	gcc \
	gdbm \
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
	lcdproc \
	less \
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
	litestream \
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
	openldap \
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
	pvrusb2-mci \
	pwc \
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
	syslog-ng \
	tar \
	thttpd \
	tiff \
	unzip \
	usbutils \
	util-linux \
	vim \
	vlan \
	watchdog \
	wget \
	zip \
	zlib \
	"

OPENTURBOSTATION_EXTRA_PACKAGES ?= ""

# The package-index at the end causes regeneration of the Packages.gz and
# other control files.
# openprotium-native \
DEPENDS = "\
	openprotium-image \
	${OPENTURBOSTATION_PACKAGES} \
	${OPENTURBOSTATION_EXTRA_PACKAGES} \
	package-index \
	"
