<?php

define('DB_FILENAME', '/home/angstrom/website/repo/feeds.db');
define('FB_BASE_DIR', '/home/angstrom/website/repo/');
$feed_base_url = "http://www.angstrom-distribution.org/unstable/feed/";

$feeds = array(
	array(
		'distro_name'=>'Ångström', 
		'distro_version'=>'unstable',
		'feed_base_url'=>'http://www.angstrom-distribution.org/unstable/feed/',
		'feeds'=> 
		array(
			array(
				'name'=>'All architectures',
				'url'=>'all',
			),
			array(  
				'name'=>'avr32 base',
				'url'=>'avr32/base',
			),
			array(
				'name'=>'blackfin base',
				'url'=>'blackfin/base',
			),

			array(
				'name'=>'armv5te base',
				'url'=>'armv5te/base',
			),
			array(
				'name'=>'iwmmxt base',
				'url'=>'iwmmxt/base',
			),
			array(
				'name'=>'armv5teb base',
				'url'=>'armv5teb/base',
			),
			array(
				'name'=>'arm-oabi base',
				'url'=>'arm-oabi/base',
			),

			array(  
				'name'=>'i586 base',
				'url'=>'i586/base',
			),
			array(
				'name'=>'i686 base',
				'url'=>'i686/base',
			),

			array(  
				'name'=>'armv4t base',
				'url'=>'armv4t/base',
			),
			array(
				'name'=>'armv6 base',
				'url'=>'armv6/base',
			),
			array(  
				'name'=>'ppc603e base',
				'url'=>'ppc603e/base',
			),
			array(
				'name'=>'ppc405 base',
				'url'=>'ppc405/base',
			),

			array(  
				'name'=>'armv5te perl',
				'url'=>'armv5te/perl',
			),
			array(  
				'name'=>'armv5te python',
				'url'=>'armv5te/python',
			),
			array(
				'name'=>'armv5te gstreamer',
				'url'=>'armv5te/gstreamer',
			),
			array(
				'name'=>'avr32 perl',
				'url'=>'avr32/perl',
			),
			array(
				'name'=>'avr32 python',
				'url'=>'avr32/python',
			),
			array(
				'name'=>'avr32 gstreamer',
				'url'=>'avr32/gstreamer',
			),

			array(
				'name'=>'blackfin perl',
				'url'=>'blackfin/perl',
			),
			array(
				'name'=>'blackfin python',
				'url'=>'blackfin/python',
			),
			array(
				'name'=>'blackfin gstreamer',
				'url'=>'blackfin/gstreamer',
			),
			array(
				'name'=>'armv4t perl',
				'url'=>'armv4t/perl',
			),
			array(  
				'name'=>'armv4t python',
				'url'=>'armv4t/python',
			),
			array(
				'name'=>'armv4t gstreamer',
				'url'=>'armv4t/gstreamer',
			), 

			array(
				'name'=>'armv6 perl',
				'url'=>'armv6/perl',
			),
			array(
				'name'=>'armv6 python',
				'url'=>'armv6/python',
			),
			array(
				'name'=>'armv6 gstreamer',
				'url'=>'armv6/gstreamer',
			),

			array(
				'name'=>'i686 perl',
				'url'=>'i686/perl',
			),
			array(
				'name'=>'i686 python',
				'url'=>'i686/python',
			),
			array(  
				'name'=>'i686 gstreamer',
				'url'=>'i686/gstreamer',
			),
			array(
				'name'=>'ppc603e perl',
				'url'=>'ppc603e/perl',
			),
			array(
				'name'=>'ppc603e python',
				'url'=>'ppc603e/python',
			),
			array(
				'name'=>'ppc603e gstreamer',
				'url'=>'ppc603e/gstreamer',
			),

			array(  
				'name'=>'Beagleboard machine feed',
				'url'=>'armv7a/machine/beagleboard',
			),
			array(  
				'name'=>'Hawkoard machine feed',
				'url'=>'armv5te/machine/hawkboard',
			),
			array(
				'name'=>'Motorola A780',
				'url'=>'armv5te/machine/a780',
			),
			array(
				'name'=>'HP iPAQ h2200',
				'url'=>'armv5te/machine/h2200',
			),

			array(
				'name'=>'HP iPAQ h4000',
				'url'=>'armv5te/machine/h4000',
			),

			array(
				'name'=>'HTC universal/ iMate jasjar',
				'url'=>'armv5te/machine/htcuniversal',
			),
			array(
				'name'=>'HP iPAQ hx4700',
				'url'=>'armv5te/machine/hx4700',
			),
			array(
				'name'=>'HP iPAQ hx2000 series',
				'url'=>'armv5te/machine/hx2000',
			),

			array(
				'name'=>'Psion Teklogix NetBook Pro',
				'url'=>'armv5te/machine/netbook-pro',
			),
			array(
				'name'=>'HTC Magician',
				'url'=>'armv5te/machine/magician',
			),
			array(
				'name'=>'Nokia 770 internet tablet',
				'url'=>'armv5te/machine/nokia770',
			),				     				     
			array(
				'name'=>'Sharp Zaurus 5600 (Poodle)',
				'url'=>'armv5te/machine/poodle',
			),
			array(
				'name'=>'Sharp Zaurus c7x0 (Corgi, Boxer, Husky, Shepher)',
				'url'=>'armv5te/machine/c7x0',
			),
			array(  
				'name'=>'Sharp Zaurus SL-C1000 (akita)',
				'url'=>'armv5te/machine/akita',
			),
			array(  
				'name'=>'HP iPAQ h5xxx series',
				'url'=>'armv5te/machine/h5xxx',
			),
			array(
				'name'=>'Sharp Zaurus SL-C6000 (Tosa)',
				'url'=>'armv5te/machine/tosa',
			),
			array(
				'name'=>'Sharp Zaurus SL-C3xxx (Spitz, Borzoi, Terrier)',
				'url'=>'armv5te/machine/spitz',
			),
			array(
				'name'=>'Cirrus Logic ep93xx boards',
				'url'=>'armv4t/machine/ep93xx',
			),
			array(
				'name'=>'FIC gta01/Neo1973 phone',
				'url'=>'armv4t/machine/fic-gta01',
			),

			array(
				'name'=>'HP iPAQ h6300',
				'url'=>'armv4t/machine/h6300',
			),
			array(
				'name'=>'Freescale i.mx31 ADS development board',
				'url'=>'armv6/machine/mx31ads',
			),

			array(
				'name'=>'Tyan thunder K7 s2462 mainboard (guinness)',
				'url'=>'i686/machine/guinness',
			),
			array(
				'name'=>'Progear webpad',
				'url'=>'i686/machine/progear',
			),
			array(
				'name'=>'Genesi Efika',
				'url'=>'ppc603e/machine/efika',
			),

		)// end distro[feeds]	
	), //end distro
	array(
		'distro_name'=>'Ångström',
		'distro_version'=>'2007.12 glibc',
		'feed_base_url'=>'http://www.angstrom-distribution.org/feeds/2007/ipk/glibc/',
		'feeds'=>
		array( 
			array(
				'name'=>'noarch feed',
				'url'=>'all',
			),
			array(  
				'name'=>'arm-oabi architecture base feed',
				'url'=>'arm-oabi/base',
			),
			array(  
				'name'=>'arm-oabi architecture gstreamer feed',
				'url'=>'arm-oabi/gstreamer',
			),
			array(  
				'name'=>'arm-oabi architecture perl feed',
				'url'=>'arm-oabi/perl',
			),
			array(  
				'name'=>'arm-oabi architecture python feed',
				'url'=>'arm-oabi/python',
			),
			array(  
				'name'=>'armv4t architecture base feed',
				'url'=>'armv4t/base',
			),
			array(  
				'name'=>'armv4t architecture gstreamer feed',
				'url'=>'armv4t/gstreamer',
			),
			array(  
				'name'=>'armv4t architecture perl feed',
				'url'=>'armv4t/perl',
			),
			array(  
				'name'=>'armv4t architecture python feed',
				'url'=>'armv4t/python',
			),
			array(  
				'name'=>'armv5te architecture base feed',
				'url'=>'armv5te/base',
			),
			array(  
				'name'=>'armv5te architecture gstreamer feed',
				'url'=>'armv5te/gstreamer',
			),
			array(  
				'name'=>'armv5te architecture perl feed',
				'url'=>'armv5te/perl',
			),
			array(  
				'name'=>'armv5te architecture python feed',
				'url'=>'armv5te/python',
			),
			array(  
				'name'=>'armv5teb architecture base feed',
				'url'=>'armv5teb/base',
			),
			array(  
				'name'=>'armv5teb architecture gstreamer feed',
				'url'=>'armv5teb/gstreamer',
			),
			array(  
				'name'=>'armv5teb architecture perl feed',
				'url'=>'armv5teb/perl',
			),
			array(  
				'name'=>'armv5teb architecture python feed',
				'url'=>'armv5teb/python',
			),
			array(  
				'name'=>'armv6 architecture base feed',
				'url'=>'armv6/base',
			),
			array(  
				'name'=>'armv6 architecture gstreamer feed',
				'url'=>'armv6/gstreamer',
			),
			array(  
				'name'=>'armv6 architecture perl feed',
				'url'=>'armv6/perl',
			),
			array(  
				'name'=>'armv6 architecture python feed',
				'url'=>'armv6/python',
			),
			array(  
				'name'=>'i486 architecture base feed',
				'url'=>'i486/base',
			),
			array(  
				'name'=>'i486 architecture gstreamer feed',
				'url'=>'i486/gstreamer',
			),
			array(  
				'name'=>'i486 architecture perl feed',
				'url'=>'i486/perl',
			),
			array(  
				'name'=>'i486 architecture python feed',
				'url'=>'i486/python',
			),
			array(  
				'name'=>'i586 architecture base feed',
				'url'=>'i586/base',
			),
			array(  
				'name'=>'i586 architecture gstreamer feed',
				'url'=>'i586/gstreamer',
			),
			array(  
				'name'=>'i586 architecture perl feed',
				'url'=>'i586/perl',
			),
			array(  
				'name'=>'i586 architecture python feed',
				'url'=>'i586/python',
			),
			array(  
				'name'=>'i686 architecture base feed',
				'url'=>'i686/base',
			),
			array(  
				'name'=>'i686 architecture gstreamer feed',
				'url'=>'i686/gstreamer',
			),
			array(  
				'name'=>'i686 architecture perl feed',
				'url'=>'i686/perl',
			),
			array(  
				'name'=>'i686 architecture python feed',
				'url'=>'i686/python',
			),
			array(  
				'name'=>'iwmmxt architecture base feed',
				'url'=>'iwmmxt/base',
			),
			array(  
				'name'=>'iwmmxt architecture gstreamer feed',
				'url'=>'iwmmxt/gstreamer',
			),
			array(  
				'name'=>'iwmmxt architecture perl feed',
				'url'=>'iwmmxt/perl',
			),
			array(  
				'name'=>'iwmmxt architecture python feed',
				'url'=>'iwmmxt/python',
			),
			array(  
				'name'=>'ppc405 architecture base feed',
				'url'=>'ppc405/base',
			),
			array(  
				'name'=>'ppc405 architecture gstreamer feed',
				'url'=>'ppc405/gstreamer',
			),
			array(  
				'name'=>'ppc405 architecture perl feed',
				'url'=>'ppc405/perl',
			),
			array(  
				'name'=>'ppc405 architecture python feed',
				'url'=>'ppc405/python',
			),
			array(  
				'name'=>'ppc603e architecture base feed',
				'url'=>'ppc603e/base',
			),
			array(  
				'name'=>'ppc603e architecture gstreamer feed',
				'url'=>'ppc603e/gstreamer',
			),
			array(  
				'name'=>'ppc603e architecture perl feed',
				'url'=>'ppc603e/perl',
			),
			array(  
				'name'=>'ppc603e architecture python feed',
				'url'=>'ppc603e/python',
			),
			//machines
			array(  
				'name'=>'ep93xx machine feed',
				'url'=>'armv4t/machine/ep93xx',
			),
			array(  
				'name'=>'h6300 machine feed',
				'url'=>'armv4t/machine/h6300',
			),
			array(  
				'name'=>'fic-gta01 machine feed',
				'url'=>'armv4t/machine/fic-gta01',
			),
			array(  
				'name'=>'fic-gta02 machine feed',
				'url'=>'armv4t/machine/fic-gta02',
			),
			array(  
				'name'=>'davinci-dvevm machine feed',
				'url'=>'armv5te/machine/davinci-dvevm',
			),
			array(  
				'name'=>'gumstix-connex machine feed',
				'url'=>'armv5te/machine/gumstix-connex',
			),
			array(  
				'name'=>'gumstix-verdex machine feed',
				'url'=>'armv5te/machine/gumstix-verdex',
			),
			array(  
				'name'=>'gumstix machine feed',
				'url'=>'armv5te/machine/gumstix',
			),
			array(  
				'name'=>'e680 machine feed',
				'url'=>'armv5te/machine/e680',
			),
			array(  
				'name'=>'a780 machine feed',
				'url'=>'armv5te/machine/a780',
			),
			array(  
				'name'=>'a1200 machine feed',
				'url'=>'armv5te/machine/a1200',
			),
			array(  
				'name'=>'at91sam9263ek machine feed',
				'url'=>'armv5te/machine/at91sam9263ek',
			),
			array(  
				'name'=>'rokre6 machine feed',
				'url'=>'armv5te/machine/rokre6',
			),
			array(  
				'name'=>'rokre2 machine feed',
				'url'=>'armv5te/machine/rokre2',
			),
			array(  
				'name'=>'rokr-e2 machine feed',
				'url'=>'armv5te/machine/rokr-e2',
			),
			array(  
				'name'=>'akita machine feed',
				'url'=>'armv5te/machine/akita',
			),
			array(  
				'name'=>'c7x0 machine feed',
				'url'=>'armv5te/machine/c7x0',
			),
			array(  
				'name'=>'h2200 machine feed',
				'url'=>'armv5te/machine/h2200',
			),
			array(  
				'name'=>'h3900 machine feed',
				'url'=>'armv5te/machine/h3900',
			),
			array(  
				'name'=>'h4000 machine feed',
				'url'=>'armv5te/machine/h4000',
			),
			array(  
				'name'=>'h5000 machine feed',
				'url'=>'armv5te/machine/h5000',
			),
			array(  
				'name'=>'htcapache machine feed',
				'url'=>'armv5te/machine/htcapache',
			),
			array(  
				'name'=>'htctornado machine feed',
				'url'=>'armv5te/machine/htctornado',
			),
			array(  
				'name'=>'htcblueangel machine feed',
				'url'=>'armv5te/machine/htcblueangel',
			),
			array(  
				'name'=>'htcuniversal machine feed',
				'url'=>'armv5te/machine/htcuniversal',
			),
			array(  
				'name'=>'hx4700 machine feed',
				'url'=>'armv5te/machine/hx4700',
			),
			array(  
				'name'=>'nslu2le machine feed',
				'url'=>'armv5te/machine/nslu2le',
			),
			array(  
				'name'=>'hx2000 machine feed',
				'url'=>'armv5te/machine/hx2000',
			),
			array(  
				'name'=>'ixp4xxle machine feed',
				'url'=>'armv5te/machine/ixp4xxle',
			),
			array(  
				'name'=>'magician machine feed',
				'url'=>'armv5te/machine/magician',
			),
			array(  
				'name'=>'netbook-pro machine feed',
				'url'=>'armv5te/machine/netbook-pro',
			),
			array(  
				'name'=>'nokia770 machine feed',
				'url'=>'armv5te/machine/nokia770',
			),
			array(  
				'name'=>'qemuarm machine feed',
				'url'=>'armv5te/machine/qemuarm',
			),
			array(  
				'name'=>'omap5912osk machine feed',
				'url'=>'armv5te/machine/omap5912osk',
			),
			array(  
				'name'=>'poodle machine feed',
				'url'=>'armv5te/machine/poodle',
			),
			array(  
				'name'=>'spitz machine feed',
				'url'=>'armv5te/machine/spitz',
			),
			array(  
				'name'=>'tosa machine feed',
				'url'=>'armv5te/machine/tosa',
			),
			array(  
				'name'=>'h3600 machine feed',
				'url'=>'arm-oabi/machine/h3600',
			),
			array(  
				'name'=>'h3800 machine feed',
				'url'=>'arm-oabi/machine/h3800',
			),
			array(  
				'name'=>'collie machine feed',
				'url'=>'arm-oabi/machine/collie',
			),
			array(  
				'name'=>'simpad machine feed',
				'url'=>'arm-oabi/machine/simpad',
			),
			array(  
				'name'=>'htcwallaby machine feed',
				'url'=>'arm-oabi/machine/htcwallaby',
			),
			array(  
				'name'=>'atngw100 machine feed',
				'url'=>'avr32/machine/atngw100',
			),
			array(  
				'name'=>'at32stk1000 machine feed',
				'url'=>'avr32/machine/at32stk1000',
			),
		) // end distro['feeds'] 
	), //end distro
	array(
		'distro_name'=>'Ångström',
		'distro_version'=>'2008.6 glibc',
		'feed_base_url'=>'http://www.angstrom-distribution.org/feeds/2008/ipk/glibc/',
		'feeds'=>
		array( 
			array(
				'name'=>'noarch feed',
				'url'=>'all',
			),
			array(  
				'name'=>'arm-oabi architecture base feed',
				'url'=>'arm-oabi/base',
			),
			array(  
				'name'=>'arm-oabi architecture gstreamer feed',
				'url'=>'arm-oabi/gstreamer',
			),
			array(  
				'name'=>'arm-oabi architecture perl feed',
				'url'=>'arm-oabi/perl',
			),
			array(  
				'name'=>'arm-oabi architecture python feed',
				'url'=>'arm-oabi/python',
			),
			array(  
				'name'=>'armv4t architecture base feed',
				'url'=>'armv4t/base',
			),
			array(  
				'name'=>'armv4t architecture gstreamer feed',
				'url'=>'armv4t/gstreamer',
			),
			array(  
				'name'=>'armv4t architecture perl feed',
				'url'=>'armv4t/perl',
			),
			array(  
				'name'=>'armv4t architecture python feed',
				'url'=>'armv4t/python',
			),
			array(  
				'name'=>'armv5te architecture base feed',
				'url'=>'armv5te/base',
			),
			array(  
				'name'=>'armv5te architecture gstreamer feed',
				'url'=>'armv5te/gstreamer',
			),
			array(  
				'name'=>'armv5te architecture perl feed',
				'url'=>'armv5te/perl',
			),
			array(  
				'name'=>'armv5te architecture python feed',
				'url'=>'armv5te/python',
			),
			array(  
				'name'=>'armv5teb architecture base feed',
				'url'=>'armv5teb/base',
			),
			array(  
				'name'=>'armv5teb architecture gstreamer feed',
				'url'=>'armv5teb/gstreamer',
			),
			array(  
				'name'=>'armv5teb architecture perl feed',
				'url'=>'armv5teb/perl',
			),
			array(  
				'name'=>'armv5teb architecture python feed',
				'url'=>'armv5teb/python',
			),
			array(  
				'name'=>'armv6 architecture base feed',
				'url'=>'armv6/base',
			),
			array(  
				'name'=>'armv6 architecture gstreamer feed',
				'url'=>'armv6/gstreamer',
			),
			array(  
				'name'=>'armv6 architecture perl feed',
				'url'=>'armv6/perl',
			),
			array(  
				'name'=>'armv6 architecture python feed',
				'url'=>'armv6/python',
			),
			array(
				'name'=>'armv6-novfp architecture base feed',
				'url'=>'armv6-novfp/base',
			),
			array(
				'name'=>'armv6-novfp architecture gstreamer feed',
				'url'=>'armv6-novfp/gstreamer',
			),
			array(
				'name'=>'armv6-novfp architecture perl feed',
				'url'=>'armv6-novfp/perl',
			),
			array(
				'name'=>'armv6-novfp architecture python feed',
				'url'=>'armv6-novfp/python',
			),
			array(
				'name'=>'armv7-a architecture base feed',
				'url'=>'armv7a/base',
			),
			array(
				'name'=>'armv7-a architecture gstreamer feed',
				'url'=>'armv7a/gstreamer',
			),
			array(
				'name'=>'armv7-a architecture perl feed',
				'url'=>'armv7a/perl',
			),
			array(
				'name'=>'armv7-a architecture python feed',
				'url'=>'armv7a/python',
			),
			array(  
				'name'=>'i486 architecture base feed',
				'url'=>'i486/base',
			),
			array(  
				'name'=>'i486 architecture gstreamer feed',
				'url'=>'i486/gstreamer',
			),
			array(  
				'name'=>'i486 architecture perl feed',
				'url'=>'i486/perl',
			),
			array(  
				'name'=>'i486 architecture python feed',
				'url'=>'i486/python',
			),
			array(  
				'name'=>'i586 architecture base feed',
				'url'=>'i586/base',
			),
			array(  
				'name'=>'i586 architecture gstreamer feed',
				'url'=>'i586/gstreamer',
			),
			array(  
				'name'=>'i586 architecture perl feed',
				'url'=>'i586/perl',
			),
			array(  
				'name'=>'i586 architecture python feed',
				'url'=>'i586/python',
			),
			array(  
				'name'=>'i686 architecture base feed',
				'url'=>'i686/base',
			),
			array(  
				'name'=>'i686 architecture gstreamer feed',
				'url'=>'i686/gstreamer',
			),
			array(  
				'name'=>'i686 architecture perl feed',
				'url'=>'i686/perl',
			),
			array(  
				'name'=>'i686 architecture python feed',
				'url'=>'i686/python',
			),
			array(  
				'name'=>'iwmmxt architecture base feed',
				'url'=>'iwmmxt/base',
			),
			array(  
				'name'=>'iwmmxt architecture gstreamer feed',
				'url'=>'iwmmxt/gstreamer',
			),
			array(  
				'name'=>'iwmmxt architecture perl feed',
				'url'=>'iwmmxt/perl',
			),
			array(  
				'name'=>'iwmmxt architecture python feed',
				'url'=>'iwmmxt/python',
			),
			array(  
				'name'=>'ppc405 architecture base feed',
				'url'=>'ppc405/base',
			),
			array(  
				'name'=>'ppc405 architecture gstreamer feed',
				'url'=>'ppc405/gstreamer',
			),
			array(  
				'name'=>'ppc405 architecture perl feed',
				'url'=>'ppc405/perl',
			),
			array(  
				'name'=>'ppc405 architecture python feed',
				'url'=>'ppc405/python',
			),
			array(  
				'name'=>'ppc603e architecture base feed',
				'url'=>'ppc603e/base',
			),
			array(  
				'name'=>'ppc603e architecture gstreamer feed',
				'url'=>'ppc603e/gstreamer',
			),
			array(  
				'name'=>'ppc603e architecture perl feed',
				'url'=>'ppc603e/perl',
			),
			array(  
				'name'=>'ppc603e architecture python feed',
				'url'=>'ppc603e/python',
			),
			array(  
				'name'=>'ep93xx machine feed',
				'url'=>'armv4t/machine/ep93xx',
			),
			array(  
				'name'=>'h6300 machine feed',
				'url'=>'armv4t/machine/h6300',
			),
			array(  
				'name'=>'fic-gta01 machine feed',
				'url'=>'armv4t/machine/fic-gta01',
			),
			array(  
				'name'=>'fic-gta02 machine feed',
				'url'=>'armv4t/machine/fic-gta02',
			),
			array(  
				'name'=>'davinci-dvevm machine feed',
				'url'=>'armv5te/machine/davinci-dvevm',
			),
			array(  
				'name'=>'gumstix-connex machine feed',
				'url'=>'armv5te/machine/gumstix-connex',
			),
			array(  
				'name'=>'gumstix-verdex machine feed',
				'url'=>'armv5te/machine/gumstix-verdex',
			),
			array(  
				'name'=>'gumstix machine feed',
				'url'=>'armv5te/machine/gumstix',
			),
			array(  
				'name'=>'e680 machine feed',
				'url'=>'armv5te/machine/e680',
			),
			array(  
				'name'=>'a780 machine feed',
				'url'=>'armv5te/machine/a780',
			),
			array(  
				'name'=>'a1200 machine feed',
				'url'=>'armv5te/machine/a1200',
			),
			array(  
				'name'=>'at91sam9263ek machine feed',
				'url'=>'armv5te/machine/at91sam9263ek',
			),
			array(  
				'name'=>'rokre6 machine feed',
				'url'=>'armv5te/machine/rokre6',
			),
			array(  
				'name'=>'rokre2 machine feed',
				'url'=>'armv5te/machine/rokre2',
			),
			array(  
				'name'=>'rokr-e2 machine feed',
				'url'=>'armv5te/machine/rokr-e2',
			),
			array(  
				'name'=>'akita machine feed',
				'url'=>'armv5te/machine/akita',
			),
			array(  
				'name'=>'c7x0 machine feed',
				'url'=>'armv5te/machine/c7x0',
			),
			array(  
				'name'=>'h2200 machine feed',
				'url'=>'armv5te/machine/h2200',
			),
			array(  
				'name'=>'h3900 machine feed',
				'url'=>'armv5te/machine/h3900',
			),
			array(  
				'name'=>'h4000 machine feed',
				'url'=>'armv5te/machine/h4000',
			),
			array(  
				'name'=>'h5000 machine feed',
				'url'=>'armv5te/machine/h5000',
			),
			array(  
				'name'=>'htcapache machine feed',
				'url'=>'armv5te/machine/htcapache',
			),
			array(  
				'name'=>'htctornado machine feed',
				'url'=>'armv5te/machine/htctornado',
			),
			array(  
				'name'=>'htcblueangel machine feed',
				'url'=>'armv5te/machine/htcblueangel',
			),
			array(  
				'name'=>'htcuniversal machine feed',
				'url'=>'armv5te/machine/htcuniversal',
			),
			array(  
				'name'=>'hx4700 machine feed',
				'url'=>'armv5te/machine/hx4700',
			),
			array(  
				'name'=>'nslu2le machine feed',
				'url'=>'armv5te/machine/nslu2le',
			),
			array(  
				'name'=>'hx2000 machine feed',
				'url'=>'armv5te/machine/hx2000',
			),
			array(  
				'name'=>'ixp4xxle machine feed',
				'url'=>'armv5te/machine/ixp4xxle',
			),
			array(  
				'name'=>'magician machine feed',
				'url'=>'armv5te/machine/magician',
			),
			array(  
				'name'=>'netbook-pro machine feed',
				'url'=>'armv5te/machine/netbook-pro',
			),
			array(  
				'name'=>'nokia770 machine feed',
				'url'=>'armv5te/machine/nokia770',
			),
			array(  
				'name'=>'qemuarm machine feed',
				'url'=>'armv5te/machine/qemuarm',
			),
			array(  
				'name'=>'omap5912osk machine feed',
				'url'=>'armv5te/machine/omap5912osk',
			),
			array(  
				'name'=>'poodle machine feed',
				'url'=>'armv5te/machine/poodle',
			),
			array(  
				'name'=>'spitz machine feed',
				'url'=>'armv5te/machine/spitz',
			),
			array(  
				'name'=>'tosa machine feed',
				'url'=>'armv5te/machine/tosa',
			),
			array(
				'name'=>'Beagle Board  machine feed',
				'url'=>'armv7a/machine/beagleboard',
			),
			array(  
				'name'=>'h3600 machine feed',
				'url'=>'arm-oabi/machine/h3600',
			),
			array(  
				'name'=>'h3800 machine feed',
				'url'=>'arm-oabi/machine/h3800',
			),
			array(  
				'name'=>'collie machine feed',
				'url'=>'arm-oabi/machine/collie',
			),
			array(  
				'name'=>'simpad machine feed',
				'url'=>'arm-oabi/machine/simpad',
			),
			array(  
				'name'=>'htcwallaby machine feed',
				'url'=>'arm-oabi/machine/htcwallaby',
			),
			array(  
				'name'=>'atngw100 machine feed',
				'url'=>'avr32/machine/atngw100',
			),
			array(  
				'name'=>'at32stk1000 machine feed',
				'url'=>'avr32/machine/at32stk1000',
			)
		)// end distro[feeds]s		
	),// end distro
	array(
		'distro_name'=>'Ångström',
		'distro_version'=>'2008.6 uClibc',
		'feed_base_url'=>'http://www.angstrom-distribution.org/feeds/2008/ipk/uclibc/',
		'feeds'=>
		array( 
			array(
				'name'=>' noarch feed',
				'url'=>'all',
			),
			array(  
				'name'=>' avr32 architecture base feed',
				'url'=>'avr32/base',
			),
			array(  
				'name'=>' avr32 architecture gstreamer feed',
				'url'=>'avr32/gstreamer',
			),
			array(  
				'name'=>' avr32 architecture perl feed',
				'url'=>'avr32/perl',
			),
			array(  
				'name'=>' avr32 architecture python feed',
				'url'=>'avr32/python',
			),

			array(  
				'name'=>' arm-oabi architecture base feed',
				'url'=>'arm-oabi/base',
			),
			array(  
				'name'=>' arm-oabi architecture gstreamer feed',
				'url'=>'arm-oabi/gstreamer',
			),
			array(  
				'name'=>' arm-oabi architecture perl feed',
				'url'=>'arm-oabi/perl',
			),
			array(  
				'name'=>' arm-oabi architecture python feed',
				'url'=>'arm-oabi/python',
			),
			array(  
				'name'=>' armv4t architecture base feed',
				'url'=>'armv4t/base',
			),
			array(  
				'name'=>' armv4t architecture gstreamer feed',
				'url'=>'armv4t/gstreamer',
			),
			array(  
				'name'=>' armv4t architecture perl feed',
				'url'=>'armv4t/perl',
			),
			array(  
				'name'=>' armv4t architecture python feed',
				'url'=>'armv4t/python',
			),
			array(  
				'name'=>' armv5te architecture base feed',
				'url'=>'armv5te/base',
			),
			array(  
				'name'=>' armv5te architecture gstreamer feed',
				'url'=>'armv5te/gstreamer',
			),
			array(  
				'name'=>' armv5te architecture perl feed',
				'url'=>'armv5te/perl',
			),
			array(  
				'name'=>' armv5te architecture python feed',
				'url'=>'armv5te/python',
			),
			array(  
				'name'=>' armv5teb architecture base feed',
				'url'=>'armv5teb/base',
			),
			array(  
				'name'=>' armv5teb architecture gstreamer feed',
				'url'=>'armv5teb/gstreamer',
			),
			array(  
				'name'=>' armv5teb architecture perl feed',
				'url'=>'armv5teb/perl',
			),
			array(  
				'name'=>' armv5teb architecture python feed',
				'url'=>'armv5teb/python',
			),
			array(  
				'name'=>' armv6 architecture base feed',
				'url'=>'armv6/base',
			),
			array(  
				'name'=>' armv6 architecture gstreamer feed',
				'url'=>'armv6/gstreamer',
			),
			array(  
				'name'=>' armv6 architecture perl feed',
				'url'=>'armv6/perl',
			),
			array(  
				'name'=>' armv6 architecture python feed',
				'url'=>'armv6/python',
			),
			array(  
				'name'=>' i486 architecture base feed',
				'url'=>'i486/base',
			),
			array(  
				'name'=>' i486 architecture gstreamer feed',
				'url'=>'i486/gstreamer',
			),
			array(  
				'name'=>' i486 architecture perl feed',
				'url'=>'i486/perl',
			),
			array(  
				'name'=>' i486 architecture python feed',
				'url'=>'i486/python',
			),
			array(  
				'name'=>' i586 architecture base feed',
				'url'=>'i586/base',
			),
			array(  
				'name'=>' i586 architecture gstreamer feed',
				'url'=>'i586/gstreamer',
			),
			array(  
				'name'=>' i586 architecture perl feed',
				'url'=>'i586/perl',
			),
			array(  
				'name'=>' i586 architecture python feed',
				'url'=>'i586/python',
			),
			array(  
				'name'=>' i686 architecture base feed',
				'url'=>'i686/base',
			),
			array(  
				'name'=>' i686 architecture gstreamer feed',
				'url'=>'i686/gstreamer',
			),
			array(  
				'name'=>' i686 architecture perl feed',
				'url'=>'i686/perl',
			),
			array(  
				'name'=>' i686 architecture python feed',
				'url'=>'i686/python',
			),
			array(  
				'name'=>' iwmmxt architecture base feed',
				'url'=>'iwmmxt/base',
			),
			array(  
				'name'=>' iwmmxt architecture gstreamer feed',
				'url'=>'iwmmxt/gstreamer',
			),
			array(  
				'name'=>' iwmmxt architecture perl feed',
				'url'=>'iwmmxt/perl',
			),
			array(  
				'name'=>' iwmmxt architecture python feed',
				'url'=>'iwmmxt/python',
			),
			array(  
				'name'=>' ppc405 architecture base feed',
				'url'=>'ppc405/base',
			),
			array(  
				'name'=>' ppc405 architecture gstreamer feed',
				'url'=>'ppc405/gstreamer',
			),
			array(  
				'name'=>' ppc405 architecture perl feed',
				'url'=>'ppc405/perl',
			),
			array(  
				'name'=>' ppc405 architecture python feed',
				'url'=>'ppc405/python',
			),
			array(  
				'name'=>' ppc603e architecture base feed',
				'url'=>'ppc603e/base',
			),
			array(  
				'name'=>' ppc603e architecture gstreamer feed',
				'url'=>'ppc603e/gstreamer',
			),
			array(  
				'name'=>' ppc603e architecture perl feed',
				'url'=>'ppc603e/perl',
			),
			array(  
				'name'=>' ppc603e architecture python feed',
				'url'=>'ppc603e/python',
			),
			array(  
				'name'=>'ep93xx machine feed',
				'url'=>'armv4t/machine/ep93xx',
			),
			array(  
				'name'=>'h6300 machine feed',
				'url'=>'armv4t/machine/h6300',
			),
			array(  
				'name'=>'fic-gta01 machine feed',
				'url'=>'armv4t/machine/fic-gta01',
			),
			array(  
				'name'=>'fic-gta02 machine feed',
				'url'=>'armv4t/machine/fic-gta02',
			),
			array(  
				'name'=>'davinci-dvevm machine feed',
				'url'=>'armv5te/machine/davinci-dvevm',
			),
			array(  
				'name'=>'gumstix-connex machine feed',
				'url'=>'armv5te/machine/gumstix-connex',
			),
			array(  
				'name'=>'gumstix-verdex machine feed',
				'url'=>'armv5te/machine/gumstix-verdex',
			),
			array(  
				'name'=>'gumstix machine feed',
				'url'=>'armv5te/machine/gumstix',
			),
			array(  
				'name'=>'e680 machine feed',
				'url'=>'armv5te/machine/e680',
			),
			array(  
				'name'=>'a780 machine feed',
				'url'=>'armv5te/machine/a780',
			),
			array(  
				'name'=>'a1200 machine feed',
				'url'=>'armv5te/machine/a1200',
			),
			array(  
				'name'=>'at91sam9263ek machine feed',
				'url'=>'armv5te/machine/at91sam9263ek',
			),
			array(  
				'name'=>'rokre6 machine feed',
				'url'=>'armv5te/machine/rokre6',
			),
			array(  
				'name'=>'rokre2 machine feed',
				'url'=>'armv5te/machine/rokre2',
			),
			array(  
				'name'=>'rokr-e2 machine feed',
				'url'=>'armv5te/machine/rokr-e2',
			),
			array(  
				'name'=>'akita machine feed',
				'url'=>'armv5te/machine/akita',
			),
			array(  
				'name'=>'c7x0 machine feed',
				'url'=>'armv5te/machine/c7x0',
			),
			array(  
				'name'=>'h2200 machine feed',
				'url'=>'armv5te/machine/h2200',
			),
			array(  
				'name'=>'h3900 machine feed',
				'url'=>'armv5te/machine/h3900',
			),
			array(  
				'name'=>'h4000 machine feed',
				'url'=>'armv5te/machine/h4000',
			),
			array(  
				'name'=>'h5000 machine feed',
				'url'=>'armv5te/machine/h5000',
			),
			array(  
				'name'=>'htcapache machine feed',
				'url'=>'armv5te/machine/htcapache',
			),
			array(  
				'name'=>'htctornado machine feed',
				'url'=>'armv5te/machine/htctornado',
			),
			array(  
				'name'=>'htcblueangel machine feed',
				'url'=>'armv5te/machine/htcblueangel',
			),
			array(  
				'name'=>'htcuniversal machine feed',
				'url'=>'armv5te/machine/htcuniversal',
			),
			array(  
				'name'=>'hx4700 machine feed',
				'url'=>'armv5te/machine/hx4700',
			),
			array(  
				'name'=>'nslu2le machine feed',
				'url'=>'armv5te/machine/nslu2le',
			),
			array(  
				'name'=>'hx2000 machine feed',
				'url'=>'armv5te/machine/hx2000',
			),
			array(  
				'name'=>'ixp4xxle machine feed',
				'url'=>'armv5te/machine/ixp4xxle',
			),
			array(  
				'name'=>'magician machine feed',
				'url'=>'armv5te/machine/magician',
			),
			array(  
				'name'=>'netbook-pro machine feed',
				'url'=>'armv5te/machine/netbook-pro',
			),
			array(  
				'name'=>'nokia770 machine feed',
				'url'=>'armv5te/machine/nokia770',
			),
			array(  
				'name'=>'qemuarm machine feed',
				'url'=>'armv5te/machine/qemuarm',
			),
			array(  
				'name'=>'omap5912osk machine feed',
				'url'=>'armv5te/machine/omap5912osk',
			),
			array(  
				'name'=>'poodle machine feed',
				'url'=>'armv5te/machine/poodle',
			),
			array(  
				'name'=>'spitz machine feed',
				'url'=>'armv5te/machine/spitz',
			),
			array(  
				'name'=>'tosa machine feed',
				'url'=>'armv5te/machine/tosa',
			),
			array(  
				'name'=>'h3600 machine feed',
				'url'=>'arm-oabi/machine/h3600',
			),
			array(  
				'name'=>'h3800 machine feed',
				'url'=>'arm-oabi/machine/h3800',
			),
			array(  
				'name'=>'collie machine feed',
				'url'=>'arm-oabi/machine/collie',
			),
			array(  
				'name'=>'simpad machine feed',
				'url'=>'arm-oabi/machine/simpad',
			),
			array(  
				'name'=>'htcwallaby machine feed',
				'url'=>'arm-oabi/machine/htcwallaby',
			),
			array(  
				'name'=>'atngw100 machine feed',
				'url'=>'avr32/machine/atngw100',
			),
			array(  
				'name'=>'at32stk1000 machine feed',
				'url'=>'avr32/machine/at32stk1000',
			)
		)// end distro[feeds]s		
	)// end distro
); //end $feeds
?> 
