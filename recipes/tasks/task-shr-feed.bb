DESCRIPTION = "SHR Feed"
PR = "r96"
PV = "1.0"
LICENSE = "GPL"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} += "\
		babiloo-efl \
		bootchart-lite \
		claws-mail \
		claws-plugin-mailmbox \
#		claws-plugin-gtkhtml2-viewer \
		claws-plugin-rssyl \
		di \
		dictator \
		dosbox \
		enotes \
		epdfview \
		mupdf \
		estardict \
		evopedia \
		fbreader \
		ffalarms \
		foxtrotgps \
		gpe-calendar \
		gpe-todo \
		gpe-scap \
		gpe-sketchbook \
		gpe-filemanager \
		gpe-gallery \
		gpe-timesheet \
		gpe-contacts \
		gtkmm \
		guitartune \
		jefliks \
		libyaml-perl \
		libnet-dbus-perl \
		mc \
# broken	mpd \
		mplayer \
		navit \
		omhacks \
		orrery \
		python-elementary \
		pythm \
		python-wifi \
		openmoko-agpsui \
		openvpn \
		pyphonelog \
		ffphonelog \
#		shr-config \
		shr-today \
		shr-theme-neo \
		shr-theme-o2 \
		shr-theme-niebiee \
		shr-theme-sixteen \
# gry should be in image already
#		shr-theme-gry \
		shr-splash \
		shr-splash-theme-simple \
		shr-splash-theme-dontpanic \
		shr-splash-theme-handy \
		shr-splash-theme-tux \
		shr-splash-theme-logo \
		shr-splash-theme-openmoko \
		vagalume \
		wireshark \
		x11vnc \

		pingus \
		openmoocow \
		python-pygame \
		obexpush \
		obexftp \
		obex-data-server \
		mtpaint \
		telepathy-python \
		intone-video \
		opkg-utils \
		mysql \
		fltk-chess \
		remoko \
		openbmap-logger \
		pisi \
		libnotify \
		accelges \
		ebrainy \
		sms-sentry \
		cellhunter \
		dillo2 \
		pyefl-sudoku \
#		tasks \
		dates \
		omnewrotate \
		xchat \
		python-pyid3lib \
#		libframeworkd-phonegui-efl2 \
		intone \
		vim \
		vpnc \
		emacs-x11 \
		mg \
		mcabber \
		gdb \
		oh-puzzles \
		links-x11 \
		e-wm-illume-dict-pl \
		callrec \
		midori \
		numptyphysics \
		pidgin \
		libpurple-protocol-msn \
		libpurple-protocol-icq \
		vagalume \
		udev \
		ppp \
		bluez-hcidump \
		kbdd \
		kexec \
		mc \
		iotop \
		xprop \
		xev \
		xwininfo \
		tcpdump \
		thone \
		lsof \
		zsh \
		gzip \
		zip \
		microcom \
		minicom \
		leafpad \
		abiword \
		aspell \
		enchant \
		joe \
		nano \
		ntpclient \
		ntp \
		tor \
		vnc \
#		gpsdrive \
		wxwidgets \
		x11vnc \
#		libswt3.4-gtk-java \
		cacao \
		openjdk-6-jre \
#		jamvm \
		dbus-x11 \
#		bluez-utils-alsa \
		xournal \
#		evince \
#		asterisk \
		git \
		ruby \
		synergy \
		irssi \
		zhone \
		cu \
		net-tools \
		iproute2 \
		iputils \
		i2c-tools \
		psmisc \
		debianutils \
		tcptraceroute \
		task-proper-tools \
		wmiconfig \
		netkit-telnet \
		bind-utils \
		font-adobe-100dpi \
		font-adobe-75dpi \
		font-adobe-utopia-100dpi \
		font-adobe-utopia-75dpi \
#		font-adobe-utopia-type1 \
		font-arabic-misc \
		font-bh-100dpi \
		font-bh-75dpi \
		font-bh-lucidatypewriter-100dpi \
		font-bh-lucidatypewriter-75dpi \
#		font-bh-ttf \
#		font-bh-type1 \
		font-bitstream-100dpi \
		font-bitstream-75dpi \
		font-bitstream-speedo \
#		font-bitstream-type1 \
		font-cronyx-cyrillic \
		font-cursor-misc \
		font-daewoo-misc \
		font-dec-misc \
#		font-ibm-type1 \
		font-isas-misc \
		font-jis-misc \
		font-micro-misc \
		font-misc-cyrillic \
#		font-misc-ethiopic \
#		font-misc-meltho \
		font-misc-misc \
		font-mutt-misc \
		font-schumacher-misc \
		font-screen-cyrillic \
		font-sony-misc \
		font-sun-misc \
		font-winitzki-cyrillic \
#		font-xfree86-type1 \
		ttf-droid-sans \
		ttf-droid-sans-mono \
		ttf-droid-sans-fallback \
		ttf-droid-sans-japanese \
		ttf-droid-serif \
#		msn-pecan \
		qwo \
		fso-apm \
		fsousaged \
		fsodeviced \
		fsonetworkd \
		mdbus \
		mickeyterm \
		opimd-utils \
		omgps \
# broken	shr-launcher \
		e-tasks \
		elmdentica \
		shr-installer \
		eject \
		illume-keyboard-arabic \
		illume-keyboard-browse \
		illume-keyboard-danish \
		illume-keyboard-default-alt \
		illume-keyboard-dutch \
		illume-keyboard-dvorak \
		illume-keyboard-finnish \
		illume-keyboard-french \
		illume-keyboard-german \
		illume-keyboard-hebrew \
		illume-keyboard-numeric-alt \
		illume-keyboard-default-numeric \
		illume-keyboard-russian \
		illume-keyboard-russian-terminal \
		python-xlib \
		xcompmgr \
		man \
		man-pages \
		aceofpenguins-launcher \
		om-neon \
		ipython \
 		phoneme-advanced-foundation \
		eve \
		python-pybluez \
		x11perf \
		pyring \
		bt-configure \
		bt-gps \
		advancedcaching \
		bonnie++ \
		reiserfsprogs \
		blipomoko \
		imagemagick \
		xboard \
		sox \
#		mpg123 \
		zile \
		speex \
		podpooch \
		fltkclock \
		fltkhackdiet \
		fltkwwpointcal \
		transmission \
		xf86-input-tslib \
		xf86-video-fbdev \
		fltkcocktailbar \
		fltkcurrency \
		fltkspacetrader \
		mokoeightball \
		babiloo-efl \
		make \
		dnsmasq \
		libsyncml \
		wpa-gui \
		iliwi \
		gabriel \
		stopwatch \
		qgpslog \
		litephone \
		linphone \
		rtmom \
# broken	ventura \
		emtooth \
		emtooth2 \
		podboy \
		mcnavi \
		neolight \
		spojegui \
		dbus-daemon-proxy \
		unixbench \
# broken	maxima \
		xfsprogs \
		xfsdump \
		numberx \
		neomis \
		supertux-qvga \
		wesnoth \
		mokosuite2 \
		mokowm-imf-ecore \
		mokojeweled \
		mokohome \
		mokopanel \
		mokophone \
		atrack \
		minneo \
		gnuplot \
		galculator \
		xterm \
		ca-certificates \
		inkspill \
		dns2tcp \
		efm-nav \
		efm-path \
		efm-pathbar \
		setxkbmap \
		enjoy \
		shr-theme-efenniht \
		gwaterpas \
		sflphone-common \
		samba \
		bison \
		automake \
"

# this is only usefull on gta02 and on other devices it's trying to pull mesa-dri (not respecting DEFAULT_PROVIDER for virtual/libgl)
RDEPENDS_${PN}_append_om-gta02 = "glamo-dri-tests \
		valacompass \
"
