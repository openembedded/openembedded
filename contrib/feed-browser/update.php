<?php
/* (c) Koen Kooi 2006
 *
 * This program is free software; you can redistribute it and/or  modify it under
 * the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful,  but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public License along
 * with this library; see the file COPYING.LIB.  If not, write to the Free
 * Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307,
 * USA.         
 *              
 */         


/*
   A package entry looks like this:
   Package: zeroconf
   Version: 0.9-r0
   Depends: libc6 (>= 2.4)
   Provides: libfontconfig-utils
   Replaces: libfontconfig-utils
   Conflicts: libfontconfig-utils
   Section: net
   Architecture: armv5te
   Maintainer: Angstrom Developers <angstrom-dev@handhelds.org>
   MD5Sum: b8bd197224e24759d2162091a0fa727f
   Size: 12346
   Filename: zeroconf_0.9-r0_armv5te.ipk
   Source: http://www.progsoc.org/~wildfire/zeroconf/download/zeroconf-0.9.tar.gz file://zeroconf-default file://debian-zeroconf
   Description: IPv4 link-local address allocator
 */

error_reporting(E_ALL);

$start = time();
$p_count = 0;

define('DB_FILENAME', './feeds.db');

$feeds = db_query("SELECT f_name, f_uri FROM feeds");

foreach($feeds as $feed)
{
    print("Updating {$feed['f_name']}: {$feed['f_uri']}: ");
    db_query_n("DELETE FROM packages WHERE p_feed = '{$feed['f_name']}'");

    $count = 0;

    $packagesgz_h = fopen("compress.zlib://{$feed['f_uri']}/Packages.gz", "r");

    if ($packagesgz_h)
    {
	$package_info = array(
	    'name'=>'', 'version'=>'', 'arch'=>'', 'depends'=>'', 
	    'maintainer'=>'',  'homepage'=>'',  'section'=>'',  'replaces'=>'', 
	    'provides'=>'', 'recommends'=>'', 'conflicts'=>'', 'size'=>'',  
	    'md5sum'=>'', 'source'=>'', 'feed'=>'', 'file'=>'', 'desc'=>''
	    );

	while (!feof($packagesgz_h)) 
	{
	    $buffer = fscanf($packagesgz_h, "%[^:]: %[ -~]");
	    list ($field, $value) = $buffer;

	    if($field == 'Package' && $count > 0)
	    {
		insert_ipkgs($package_info);

		$package_info = array(
		    'name'=>'', 'version'=>'', 'arch'=>'', 'depends'=>'', 
		    'maintainer'=>'',  'homepage'=>'',  'section'=>'',  'replaces'=>'', 
		    'provides'=>'', 'recommends'=>'', 'conflicts'=>'', 'size'=>'',  
		    'md5sum'=>'', 'source'=>'', 'feed'=>'', 'file'=>'', 'desc'=>''
		);
	    }

	    switch($field)
	    {
		case 'Package':
		    $package_info['name'] = $value; 	
		    $count++;	
		    break;
		case 'Version':
		    $package_info['version'] = $value;
		    break;
		case 'Depends':
		    $package_info['depends'] = $value;
		    break;
		case 'Provides':
		    $package_info['provides'] = $value;
		    break;
		case 'Recommends':
		    $package_info['recommends'] = $value;
		    break;
		case 'Replaces':
		    $package_info['replaces'] = $value;
		    break;
		case 'Conflicts':
		    $package_info['conflicts'] = $value;
		    break;
		case 'Section':
		    $package_info['section'] = $value;
		    break;
		case 'Architecture':
		    $package_info['arch'] = $value;
		    break;
		case 'Maintainer':
		    $package_info['maintainer'] = str_replace("'","\"", $value);
		    break;
		case 'MD5sum':
		    $package_info['md5sum'] = $value;
		    break;
		case 'Size':
		    $package_info['size'] = $value;
		    break;
		case 'Filename':
		    $package_info['file'] = $value;
		    break;
		case 'Source':
		    $package_info['source'] = $value;
		    break;
		case 'Description':
		    $package_info['desc'] = str_replace("'","\"", $value);
		    break;
	    }

	}

	insert_ipkgs($package_info);
    }

    $p_count = $count + $p_count;
    print("$count packages\n");
    gzclose($packagesgz_h);
}
//close the db

$end = time();
$difference = $end - $start;

$days = floor($difference/86400);
$difference = $difference - ($days*86400);

$hours = floor($difference/3600);
$difference = $difference - ($hours*3600);

$minutes = floor($difference/60);
$difference = $difference - ($minutes*60);

$seconds = $difference;

print "Added $p_count packages in $days days, $hours hours, $minutes minutes and $seconds seconds \n";


function insert_ipkgs(&$package_info)
{
    db_query_n("INSERT INTO packages VALUES (
	'{$package_info['name']}', '{$package_info['version']}',
       	'{$package_info['arch']}', '{$package_info['depends']}',
	'{$package_info['maintainer']}',  '{$package_info['homepage']}',
	'{$package_info['section']}',  '{$package_info['replaces']}',
	'{$package_info['provides']}', '{$package_info['recommends']}',
	'{$package_info['conflicts']}', '{$package_info['size']}',
	'{$package_info['md5sum']}', '{$package_info['source']}',
	'{$package_info['feed']}', '{$package_info['file']}',
	'{$package_info['desc']}'
	)");
}


function db_query($query)
{
    $result = FALSE;

    if($db_h = sqlite_open(DB_FILENAME))
    {
	$query_h = sqlite_query ($db_h, $query);
	$result = sqlite_fetch_all ($query_h, SQLITE_ASSOC);
	sqlite_close($db_h);
    }

    return $result;
}


function db_query_n($query)
{
    $result = FALSE;

    if($db_h = sqlite_open(DB_FILENAME))
    {
	$query_h = sqlite_query ($db_h, $query);
	sqlite_close($db_h);
    }

    return $result;
}



?>
