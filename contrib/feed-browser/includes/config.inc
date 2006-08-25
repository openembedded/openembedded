<?php

define('DB_FILENAME', './feeds.db');

$feeds = array(
	array(
		'distro_name'=>'OpenZaurus', 
		'distro_version'=>'3.5.4',
		'feed_base_url'=>'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4/feed/',
		'feeds'=>array(
			array(
				'name'=>'base',
				'url'=>'base',
			),
			array(
				'name'=>'opie',
				'url'=>'opie',
			),
			array(
				'name'=>'x11',
				'url'=>'x11',
			),
			array(
				'name'=>'upgrades',
				'url'=>'upgrades',
			),
			array(
				'name'=>'perl',
				'url'=>'perl',
			),
			array(
				'name'=>'python',
				'url'=>'python',
			),
			array(
				'name'=>'Collie upgrades',
				'url'=>'upgrades/machine/collie',
			),
			array(
				'name'=>'Tosa upgrades',
				'url'=>'upgrades/machine/tosa',
			),
			array(
				'name'=>'Poodle upgrades',
				'url'=>'upgrades/machine/poodle',
			),
			array(
				'name'=>'Poodle',
				'url'=>'machine/poodle',
			),
			array(
				'name'=>'Collie',
				'url'=>'machine/collie',
			),
			array(
				'name'=>'Tosa',
				'url'=>'machine/tosa',
			)
		)
	),
	array(
		'distro_name'=>'OpenZaurus', 
		'distro_version'=>'3.5.4.1',
		'feed_base_url'=>'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/',
		'feeds'=>array(
			array(
				'name'=>'base',
				'url'=>'base',
			),
			array(
				'name'=>'opie',
				'url'=>'opie',
			),
			array(
				'name'=>'perl',
				'url'=>'perl',
			),
			array(
				'name'=>'python',
				'url'=>'python',
			),
			array(
				'name'=>'upgrades',
				'url'=>'upgrades',
			),
			array(
				'name'=>'x11',
				'url'=>'x11',
			),
			array(
				'name'=>'C7x0',
				'url'=>'machine/c7x0',
			),
			array(
				'name'=>'Spitz',
				'url'=>'machine/spitz',
			),
			array(
				'name'=>'Akita',
				'url'=>'machine/akita',
			),
			array(
				'name'=>'Akita upgrades',
				'url'=>'upgrades/machine/akita',
			),
			array(
				'name'=>'C7x0 upgrades',
				'url'=>'upgrades/machine/c7x0',
			),
			array(
				'name'=>'Spitz upgrades',
				'url'=>'upgrades/machine/spitz',
			)
		)
	)
);

?>
