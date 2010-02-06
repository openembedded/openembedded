# Originally brought to you by the Angstrom Distribution

#############################################################################
# FEED BUILDING SETTINGS
#############################################################################

# Put links to sources in deploy/sources to make it easier for people to be GPL compliant
INHERIT += "src_distribute_local"
SRC_DIST_LOCAL ?= "symlink"

# Add FEED_ARCH to overrides
OVERRIDES .= ":${FEED_ARCH}"

FEED_ARCH ?= "${TARGET_ARCH}"

# Blackfin machines
FEED_ARCH_bfin          = "blackfin"

# armv4t machines

FEED_ARCH_acern30 	= "armv4t"
FEED_ARCH_amsdelta 	= "armv4t"
FEED_ARCH_ep93xx 	= "armv4t"
FEED_ARCH_eteng500 	= "armv4t"
FEED_ARCH_om-gta01 	= "armv4t"
FEED_ARCH_om-gta02 	= "armv4t"
FEED_ARCH_h1940 	= "armv4t"
FEED_ARCH_h6300 	= "armv4t"
FEED_ARCH_kb9202 	= "armv4t"
FEED_ARCH_ks8695 	= "armv4t"
FEED_ARCH_rx1950 	= "armv4t"
FEED_ARCH_rx3000 	= "armv4t"
FEED_ARCH_sarge-at91 	= "armv4t"
FEED_ARCH_smdk2440 	= "armv4t"
FEED_ARCH_smdk2443 	= "armv4t"

# armv5t machines

FEED_ARCH_a1200 	= "armv5te"
FEED_ARCH_a780 		= "armv5te"
FEED_ARCH_akita 	= "armv5te"
FEED_ARCH_asus620 	= "armv5te"
FEED_ARCH_asus730 	= "armv5te"
FEED_ARCH_at91sam9260ek = "armv5te"
FEED_ARCH_at91sam9261ek = "armv5te"
FEED_ARCH_at91sam9263ek = "armv5te"
FEED_ARCH_at91sam9rlek 	= "armv5te"
FEED_ARCH_at91sam9g10ek = "armv5te"
FEED_ARCH_at91sam9g20ek = "armv5te"
FEED_ARCH_at91sam9g45ekes = "armv5te"
FEED_ARCH_aximx50 	= "armv5te"
FEED_ARCH_aximx50v 	= "armv5te"
FEED_ARCH_c7x0 		= "armv5te"
FEED_ARCH_compulab-pxa270 = "armv5te"
FEED_ARCH_davinci-dvevm = "armv5te"
FEED_ARCH_devkitidp-pxa255 = "armv5te"
FEED_ARCH_e680 		= "armv5te"
FEED_ARCH_er0100 	= "armv5te"
FEED_ARCH_gumstix 	= "armv5te"
FEED_ARCH_gumstix-verdex = "armv5te"
FEED_ARCH_gumstix-connex = "armv5te"
FEED_ARCH_h1910 	= "armv5te"
FEED_ARCH_h2200 	= "armv5te"
FEED_ARCH_h3900 	= "armv5te"
FEED_ARCH_h4000 	= "armv5te"
FEED_ARCH_h5000 	= "armv5te"
FEED_ARCH_htcalpine 	= "armv5te"
FEED_ARCH_htcapache 	= "armv5te"
FEED_ARCH_htcblueangel 	= "armv5te"
FEED_ARCH_htchimalaya 	= "armv5te"
FEED_ARCH_htcsable 	= "armv5te"
FEED_ARCH_htctornado 	= "armv5te"
FEED_ARCH_htcuniversal 	= "armv5te"
FEED_ARCH_hx2000 	= "armv5te"
FEED_ARCH_hx4700 	= "armv5te"
FEED_ARCH_ixp4xxle 	= "armv5te"
FEED_ARCH_logicpd-pxa270 = "armv5te"
FEED_ARCH_looxc550 	= "armv5te"
FEED_ARCH_lsarm 	= "armv5te"
FEED_ARCH_magician 	= "armv5te"
FEED_ARCH_mainstone 	= "armv5te"
FEED_ARCH_mnci 		= "armv5te"
FEED_ARCH_mtx-3 	= "armv5te"
FEED_ARCH_mx21ads 	= "armv5te"
FEED_ARCH_n2100 	= "armv5te"
FEED_ARCH_navman-icn330 = "armv5te"
FEED_ARCH_netbook-pro 	= "armv5te"
FEED_ARCH_nokia770 	= "armv5te"
FEED_ARCH_rokre2 	= "armv5te"
FEED_ARCH_nslu2le 	= "armv5te"
FEED_ARCH_omap1510inn 	= "armv5te"
FEED_ARCH_omap1610h2 	= "armv5te"
FEED_ARCH_omap1710h3 	= "armv5te"
FEED_ARCH_omap5912osk 	= "armv5te"
FEED_ARCH_palmld 	= "armv5te"
FEED_ARCH_palmt650 	= "armv5te"
FEED_ARCH_palmt680 	= "armv5te"
FEED_ARCH_palmtc 	= "armv5te"
FEED_ARCH_palmtt 	= "armv5te"
FEED_ARCH_palmtt3 	= "armv5te"
FEED_ARCH_palmtt5 	= "armv5te"
FEED_ARCH_palmtx 	= "armv5te"
FEED_ARCH_palmz31 	= "armv5te"
FEED_ARCH_palmz71 	= "armv5te"
FEED_ARCH_palmz72 	= "armv5te"
FEED_ARCH_poodle 	= "armv5te"
FEED_ARCH_qemuarm 	= "armv5te"
FEED_ARCH_spitz 	= "armv5te"
FEED_ARCH_tosa 		= "armv5te"
FEED_ARCH_triton 	= "armv5te"

FEED_ARCH_ixp4xxbe 	= "armv5teb"
FEED_ARCH_nslu2be 	= "armv5teb"

# armv6 machines

FEED_ARCH_mx31ads 	= "armv6"
FEED_ARCH_mx31moboard	= "armv6"
FEED_ARCH_nokia800	= "armv6"
FEED_ARCH_omap2420h4	= "armv6"
FEED_ARCH_omap2430sdp   = "armv6"

# i486 machines
FEED_ARCH_geodegx 	= "i486"
FEED_ARCH_geodelx 	= "i486"
FEED_ARCH_netvista 	= "i486"
FEED_ARCH_wrap 		= "i486"
FEED_ARCH_x86 		= "i486"

# i586 machines
FEED_ARCH_epia 		= "i586"
FEED_ARCH_i586-generic 	= "i586"
FEED_ARCH_qemux86 	= "i586"

# i686 machines

FEED_ARCH_alix 		= "i686"
FEED_ARCH_colinux	= "i686"
FEED_ARCH_guinness 	= "i686"
FEED_ARCH_i686-generic 	= "i686"
FEED_ARCH_progear 	= "i686"

# powerpc machines

FEED_ARCH_dht-walnut 	= "ppc405"
FEED_ARCH_magicbox 	= "ppc405"
FEED_ARCH_xilinx-ml403 	= "ppc405"
FEED_ARCH_xilinx-ml410 	= "ppc405"
FEED_ARCH_sequoia 	= "ppc440e"
FEED_ARCH_efika 	= "ppc603e"
FEED_ARCH_lite5200 	= "ppc603e"
FEED_ARCH_lsppchd 	= "ppc603e"
FEED_ARCH_lsppchg 	= "ppc603e"
FEED_ARCH_storcenter 	= "ppc603e"
FEED_ARCH_turbostation 	= "ppc603e"
FEED_ARCH_mpc8313e-rdb 	= "ppce300c3"
FEED_ARCH_mpc8323e-rdb 	= "ppce300c2"

# strongarm machines, no EABI

FEED_ARCH_collie 	= "arm-oabi"
FEED_ARCH_h3600 	= "arm-oabi"
FEED_ARCH_h3800 	= "arm-oabi"
FEED_ARCH_htcwallaby 	= "arm-oabi"
FEED_ARCH_jornada56x 	= "arm-oabi"
FEED_ARCH_jornada7xx 	= "arm-oabi"
FEED_ARCH_shark 	= "arm-oabi"
FEED_ARCH_simpad 	= "arm-oabi"

# Tweak packaging for strongarm machines since they can't use EABI

PACKAGE_EXTRA_ARCHS_collie = "arm-oabi"
PACKAGE_EXTRA_ARCHS_h3600  = "arm-oabi"
PACKAGE_EXTRA_ARCHS_h3800  = "arm-oabi"
PACKAGE_EXTRA_ARCHS_simpad = "arm-oabi"
PACKAGE_EXTRA_ARCHS_htcwallaby = "arm-oabi"
