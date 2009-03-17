# Meta package containing all the packages which build for OPLinux and OPLinux uclibc distro
# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION = "Packages that are compatible with the OPLinux distro"
HOMEPAGE = "http://www.digital-opsis/oplinux"
LICENSE = "MIT"
PR = "r2"
PROVIDES += "${OPLINUX_IMAGENAME}-packages"

EXCLUDE_FROM_WORLD = "1"
INHIBIT_DEFAULT_DEPS = "1"
ALLOW_EMPTY = "1"


python __anonymous () {

    import bb

   #Get all the packages we can build/exist in OE
    package_list =  bb.data.getVar('PACKAGES_LIST', d) or "none"
    package_list=package_list.split()

   #Get the packages that are broken on all architectures
    broken_package_list =  bb.data.expand('${OPLINUX_BROKEN_PACKAGES}', d)

   # Get the arch we are building for
    building_arch = bb.data.getVar('FEED_ARCH',d) 

   #Now add the broken packages list the ones that fail for the arch we build now
    if (building_arch=="i486") or (building_arch=="i586") or (building_arch=="i686"):
       broken_package_list = broken_package_list + bb.data.expand('${OPLINUX_BROKEN_PACKAGES_ARCH_x86}', d)

    elif  (building_arch=="ppc405"):
           broken_package_list = broken_package_list + bb.data.expand('${OPLINUX_BROKEN_PACKAGES_ARCH_PPC}', d)

    elif (building_arch=="ppc603e"):       
           broken_package_list = broken_package_list + bb.data.expand('${OPLINUX_BROKEN_PACKAGES_ARCH_POWERPC}', d)


    for chk_package in package_list :
        build_package="yes"
        if chk_package in broken_package_list:
           build_package="no"
        else :
              bb.data.setVar('DEPENDS', (bb.data.getVar('DEPENDS', d) + chk_package +" "), d)   

#add the OPLinux extra packages to the DEPENDS list
    bb.data.setVar('DEPENDS', (bb.data.getVar('DEPENDS', d) + bb.data.getVar('OPLINUX_EXTRA_PACKAGES', d)), d)   


    bb.data.setVar('DEPENDS', (bb.data.getVar('DEPENDS', d) + "package-index"), d)   
}





# The list of packages availiable to OE 
# KEEP IN ALPHABETICAL ORDER
# Do *not* simply comment out a line. That will break. Instead
# remove the package and place it in the corresponding "broken" list
PACKAGES_LIST = "\
        acct \
        acpid \
        adns \
        aiostress \
        aircrack \
	alsa-lib \
	alsa-utils \
	apache2 \
        appweb \
        apmd \
        apt \
        ark3116 \
        arpwatch \
        at       \
        atd \
	atftp \
        atmelwlandriver \ 
	audiofile \
	aumix \
	autoconf \
	automake \
        autofs \
        aspell \
        avahi \
        bacula-client \
        balsa \
	bash \
        bazaar \
        bb \
        bc \
	beep \
        beecrypt \ 
        beepmp \
	bind \
	binutils \
        bing \
	bison \
        bitchx \
        blueprobe \
        bmon \
        boa \ 
        bochs \
        bogofilter \
        boost \      
        boost-asio \
        bonnie++ \
        bootchart \
        bootmenu \
        bootsplash \
	bridge-utils \
        bt950-cs \
        btscanner \
        btsco \
        btsco-module \
        btxml \
        bvi \
	bwmon \
        bluez-utils \
        bzflag \
        bzflag-server \
	bzip2 \
        came \
        chillispot \
        camsource \
        cscope \
        cups \
	ccxstream \
	cdparanoia \
	cdstatus \
        cetools \
	cherokee \
        ckermit \
        clish \
	coreutils \
        conserver \
        corkscrew \
        cpusage \
	cron \
	ctorrent \
	cvs \
	cyrus-sasl \
	cyrus-imapd \
        dialog \
	db \
        ddclient \
        dhclient \
        dhcp \
        didiwiki \
	devlabel \
	diffstat \
	diffutils \
	dnsmasq \
        ebtables \
        elftoaout \
        emul \
        enscript \
	e2fsprogs \
	e2fsprogs-libs \
        esmtp \
        etherpuppet \
        ethload \
        ethtool \
        ettercap \
	expat \
	ez-ipupdate \
        fortune-mod \
        fakeconnect \
        fbgrab \
	fetchmail \
	file \
	findutils \
	flac \
	flex \
	flite \
        frotz \
        fush \
        g15daemon \
	gallery \
        gammu \
	gawk \
	gcc \
	gdb \
	gdbm \
        genext2fs \
	gphoto2 \
        git \
        gift \
	glib-2.0 \
        gpm \
        gpsbabel \
        gs \
	gnu-config \
        gnuplot \
        gpsd \
	grep \
	gtk-doc \
	gzip \
	hdparm \
        hydra \
	ifupdown \
        iputils \
	ipkg-utils \
	iptables \
        intercom \
	ircp \
	irssi \
	joe \
	jpeg \
        kismet \
        kbdd \
        ksymoops \
        lame \
        lxt \
	lcdproc \
	less \
	libao \
	libpcre \
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
        mc \
        mikmod \
	mdadm \
        memtester \
	mgetty \
	miau \
	microcom \
	minicom \
	modphp \
        modplugplay \
        mp3blaster \
        mpg321 \
	mt-daapd \
	mtd-utils \
	mutt \
        mysql \
        mystun-server \
	nail \
	nano \
	ncftp \
	ncurses \
	netcat \
	nmap \
        nmixer \
	ntp \
        netkit-ftp \
        netperf \
        net-snmp \
        nfs-utils \
        ngrep \
        nmap \
        nsd \
        ntp \
        ntpdate \
	openobex-apps \
	openldap \
	openntpd \
	openobex \
        obexftp \
        obexpush \
        olsrd \
        openswan \
	openssh \
	openvpn \
	patch \
	pciutils \
        pcmcia-cs \        
        portmap \
        privoxy \
	perl \
	pkgconfig \
	ppp \
	procps \
	pvrusb2-mci \
	pwc \
	quilt \
	rng-tools \
	rsync \
	samba \
	sane-backends \
	sed \
	setpwc \
	setserial \
        shorewall \
	smartmontools \
	ssmtp \
	strace \
	streamripper \
	sysfsutils \
	syslog-ng \
        stunnel \
        spandsp \
        subversion \
        slutils \
        strace \
        sudo \
        tcpdump \
        tor \
	tar \
	thttpd \
	tiff \
        texinfo \
	unzip \
        unrar \ 
	usbutils \
	util-linux \
	vim \
	vlan \
        vorbis-tools \
        vpnc \
	vsftpd \
        vtun \
	watchdog \
	wget \
	zd1211-firmware \
	zip \
	zlib \
        zsh \
	lirc \
	masqmail \
	wakelan \
	wireless-tools \
	wpa-supplicant \
	libxml2 \
	libdvb \
	madwifi-ng \
	motion \
	ftpd-topfield \
	eciadsl \
	netpbm \
	reiserfsprogs reiser4progs \
	python \
	mpd \
	memtester \
	puppy \

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
	obexftp \
	qc-usb-messenger \
	unionfs-modules \
	unionfs-utils \
	erlang \
	ctrlproxy \
	dsniff \    
        fortune-mod \
	libpam \
	nfs-utils \
	rng-tools \
	postfix \
	yp-tools ypbind ypserv \
 
"



# Packages currently broken on all platforms (glibc)
OPLINUX_BROKEN_PACKAGES = "irssi \
	unionfs-modules \
	unionfs-utils \

"

#Here we define the packages that are broken on a specific architecture
#i486, i586, i686
OPLINUX_BROKEN_PACKAGES_ARCH_x86 =" \
        aircrack \
        appweb \
        apt \
        ark3116 \
        at \
        atmelwlandriver \ 
	atftp \
        autofs \
        balsa \
        bazaar \
        bb \
        beecrypt \
        beepmp \
        bitchx \
        bochs \
        bmon \
        bt950-cs \
        btscanner \
        btsco-module \
	bwmon \
        came \
	ctrlproxy \
	cyrus-sasl \
	cyrus-imapd \
	dsniff \    
	eciadsl \
	erlang \
        fortune-mod \
	gphoto2 \
        gpsd   \
        intercom \
        lcdproc  \
	lirc \
	mpd \
	puppy \
	pvrusb2-mci \
	pwc \
	qc-usb-messenger \
	sane-backends \
	setpwc \
        slutils \
        texinfo \
	vsftpd \
	libpam \
        aircrack \
        appweb \
        apt \
        ark3116 \
        gcc \
        gpsd \
        pvrusb2-mci \
        pwc \
        setpwc \
        cyrus-sasl \
        atftp \
        gphoto2 \
        lirc \
        libdvb \
        netpbm \
"
#
#ppc405
OPLINUX_BROKEN_PACKAGES_ARCH_PPC = " \
        aircrack \
        appweb \
        apt \
        ark3116 \
        at \
        atmelwlandriver \ 
	atftp \
        autofs \
        balsa \
        bazaar \
        bb \
        beecrypt \
        beepmp \
        bitchx \
        bochs \
        bmon \
        bt950-cs \
        btscanner \
        btsco-module \
	bwmon \
        came \
	ctrlproxy \
	cyrus-sasl \
	cyrus-imapd \
	dsniff \    
	eciadsl \
	erlang \
        fortune-mod \
	gphoto2 \
        gpsd   \
        intercom \
        lcdproc  \
	lirc \
	mpd \
	puppy \
	pvrusb2-mci \
	pwc \
	qc-usb-messenger \
	sane-backends \
	setpwc \
        slutils \
        texinfo \
	vsftpd \
"



#
#ppc440 ppc603e
OPLINUX_BROKEN_PACKAGES_ARCH_POWERPC = " \
        aircrack \
        appweb \
        apt \
        ark3116 \
        arpwatch \
        at \
        atmelwlandriver \ 
	atftp \
        autofs \
        balsa \
        bazaar \
        bb \
        beecrypt \
        beepmp \
        bitchx \
        bochs \
        bmon \
        bt950-cs \
        btscanner \
        btsco-module \
	bwmon \
        came \
	ctrlproxy \
	cyrus-sasl \
	cyrus-imapd \
	dsniff \    
	eciadsl \
	erlang \
        fortune-mod \
	gphoto2 \
        gpsd   \
        intercom \
        lcdproc  \
	lirc \
	mpd \
	puppy \
	pvrusb2-mci \
	pwc \
	qc-usb-messenger \
	sane-backends \
	setpwc \
        slutils \
        spandsp \
        texinfo \
	vsftpd \

	libpam \
        aircrack \
        appweb \
        apt \
        ark3116 \
        gcc \
        gpsd \
        pvrusb2-mci \
        pwc \
        setpwc \
        cyrus-sasl \
        atftp \
        gphoto2 \
        lirc \
        libdvb \
        netpbm \
"




#Packages broken per machine (if we ever need such a thing)
OPLINUX_BROKEN_PACKAGES_append_x86 =" \
"
OPLINUX_BROKEN_PACKAGES_append_i586-generic =" \
"
OPLINUX_BROKEN_PACKAGES_append_i686-generic =" \
"
OPLINUX_BROKEN_PACKAGES_append_epia =" \
"
OPLINUX_BROKEN_PACKAGES_append_wrap = "\
"

#ppc targets
OPLINUX_BROKEN_PACKAGES_append_magicbox = "\
"
OPLINUX_BROKEN_PACKAGES_append_dht-walnut = "\
"
#powerpc targets
OPLINUX_BROKEN_PACKAGES_append_efika = "\
"


#
#
OPLINUX_UCLIBC_UNSUPPORTABLE_PACKAGES = "\
	libpam \
	nfs-utils \
	rng-tools \
	postfix \
	yp-tools ypbind ypserv \
	"

# These packages work with glibc, but break on uclibc.
OPLINUX_UCLIBC_BROKEN_PACKAGES = "\
#	bwmon \
#	erlang \
#	apr \
#	bogofilter \
#	boost \
#	linphone \
#	sudo \
#	ushare \
	"

OPLINUX_UCLIBC_BROKEN_PACKAGES_append_x86 = "\
	"

OPLINUX_UCLIBC_BROKEN_PACKAGES_append_epia = "\
	"

OPLINUX_UCLIBC_BROKEN_PACKAGES_append_wrap = "\
	"

OPLINUX_UCLIBC_BROKEN_PACKAGES_append_magicbox = "\
	"

OPLINUX_UCLIBC_BROKEN_PACKAGES_append_dht-walnut = "\
	"


# Packages which build only with glibc (some of these use internal
# glibc functions and so will probably never run on uclibc).
OPLINUX_BROKEN_PACKAGES_append_uclibc-linux = "\
	${OPLINUX_UCLIBC_UNSUPPORTABLE_PACKAGES} \
	${OPLINUX_UCLIBC_BROKEN_PACKAGES} \

"

#
#Any extra packages defined 
#
OPLINUX_EXTRA_PACKAGES ?= ""
