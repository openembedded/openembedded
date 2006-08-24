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


$start = time();
$p_count = 0;


$feeds = db_query("SELECT f_name, f_uri FROM feeds");

foreach($feeds as $feed)
{

	print("Updating $feed[f_name]: $feed[f_uri]\n");
	db_query_n("DELETE FROM packages WHERE p_feed = '$feed[f_name]'");
	
	$count = 0;

	$packagesgz_h = fopen("compress.zlib://$feed[f_uri]/Packages.gz", "r");
	if ($packagesgz_h) {
		while (!feof($packagesgz_h)) {
			$buffer = fscanf($packagesgz_h, "%[^:]: %[ -~]");
			list ($field, $value) = $buffer;


			if($field == 'Package' && $count > 0)
			{
				insert_ipkgs ($package, $version, $depends, $section, $arch, $maintainer, $md5sum, $size, $file, $source, $desc,$feed[f_name], $conflicts, $provides, $replaces,  $recommends);
				unset($package, $version, $depends, $section, $arch, $maintainer, $md5sum, $size, $file, $source, $desc,  $conflicts, $provides, $replaces,  $recommends);
			}


			switch($field)
			{
				case 'Package':
					$package = $value; 	
					$count++;	
					break;
				case 'Version':
					$version = $value;
					break;
				case 'Depends':
					$depends = $value;
					break;
				case 'Provides':
					$provides = $value;
					break;
				case 'Recommends':
					$recommends = $value;
					break;
				case 'Replaces':
					$replaces = $value;
					break;
				case 'Conflicts':
					$conflicts = $value;
					break;
				case 'Section':
					$section = $value;
					break;
				case 'Architecture':
					$arch = $value;
					break;
				case 'Maintainer':
					$maintainer = str_replace("'","\"", $value);
					break;
				case 'MD5sum':
					$md5sum = $value;
					break;
				case 'Size':
					$size = $value;
					break;
				case 'Filename':
					$file = $value;
					break;
				case 'Source':
					$source = $value;
					break;
				case 'Description':
					$desc = str_replace("'","\"", $value);
					break;
			}

		}
		insert_ipkgs ($package, $version, $depends, $section, $arch, $maintainer, $md5sum, $size, $file, $source, $desc,$feed[f_name], $conflicts, $provides, $replaces,  $recommends);
	}

$p_count = $count + $p_count;
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


function insert_ipkgs ($package, $version, $depends, $section, $arch, $maintainer, $md5sum, $size, $file, $source, $desc, $feed, $conflicts, $provides, $replaces, $recommends)
{
	db_query_n(
		"INSERT INTO packages   (p_name,      p_version,  p_depends, p_arch, p_maintainer, p_section, p_size, p_md5,   p_source, p_desc, p_feed, p_file, p_conflicts, p_provides, p_replaces, p_recommends)
		VALUES                  ('$package', '$version', '$depends', '$arch', '$maintainer',  '$section',  '$size',  '$md5sum', '$source', '$desc', '$feed', '$file', '$conflicts', '$provides', '$replaces', '$recommends')
		");
}


function db_query($query)
{
	$db_name = "/home/koen/feeds.db";
	$db_h = sqlite_open($db_name);
	$query_h = sqlite_query ($db_h, $query);
	$result = sqlite_fetch_all ($query_h, SQLITE_ASSOC);
	sqlite_close($db_h);
	return ($result);
}


function db_query_n($query)
{
	$db_name = "/home/koen/feeds.db";
	$db_h = sqlite_open($db_name);
	$query_h = sqlite_query ($db_h, $query);
	sqlite_close($db_h);
	return ($result);
}



?>
