<?php

/*
 * (c) Koen Kooi 2006
 * (c) Marcin Juszkiewicz 2006
 *
 * This php script is intended to do the following:
 *
 * - have searchable webfronted for the feed like packages.ubuntu.com
 *
 * ToDo:
 *
 * - search functionality
 * - provide feed-management functionality
 * - allow uploading of new software
 *
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

?>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>Feed browser</title>
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css" media="all">@import "css/feed.css";</style>
<body >

<div id="page">
<ul id="menu">
<li><a href="./">Main page</a></li>
<li><a href="./?action=sectionslist">Sections list</a></li>
</ul>
<?php

error_reporting(E_ALL);

$db_name = "./feeds.db";
$db = sqlite_open($db_name);

//initialiaze db
if (db_table_exists ($db, 'packages') === FALSE)
{  
	sqlite_query ($db, "CREATE TABLE  packages (
		p_name         varchar(50),
		p_version    varchar(10),
		p_arch        varchar(12),
		p_depends    varchar(50),
		p_maintainer    varchar(50),
		p_homepage    varchar(100),
		p_section    varchar(20),
		p_replaces    varchar(50),
		p_provides    varchar(50),
		p_recommends varchar(50),
		p_conflicts    varchar(50),
		p_size        int(10),
		p_md5        char(32),
		p_source    varchar(500),
		p_feed        varchar(20),
		p_file        varchar(100),
		p_desc        varchar(1000))");
}

if (db_table_exists ($db, 'feeds') === FALSE)
{  
	sqlite_query ($db, "CREATE TABLE feeds (
		f_name         varchar(20),
		f_uri        varchar(100),
		f_comments    varchar(500))");

	test_insert_ipkgs ($db) ;
}

//close the db
sqlite_close($db);

$action = '';

if(isset($_GET['action']))
{
	$action = $_GET['action'];
}

switch($action)
{
	case "details":
		$ipkgoutput = pkgdetails ($_GET['pnm']);
		break;

	case "package":
		$edit = $_POST['edit'];
		$searchword = $edit['searchword'];
		$ipkgoutput = searchpkg ("%$searchword%");
		break;

	case "section":
		$ipkgoutput = searchsection($_GET['section']);
		break;

	case "letter":
		$letter = $_GET['g'];
		$ipkgoutput = searchletter ($letter);
		break;

	case 'sectionslist':
		$ipkgoutput = sectionslist();
		break;

	default:
		$ipkgoutput = searchletter ("a");
		break;
}


echo $ipkgoutput;

?>
</div>
</body>
</html>
<?php

function db_table_exists ($db, $mytable)
{
	if($query = sqlite_query ($db, "SELECT name FROM sqlite_master WHERE type='table'"))
	{
		$tables = sqlite_fetch_all ($query, SQLITE_ASSOC);

		if (!$tables)
		{       
			return FALSE;
		}
		else
		{ 
			foreach ($tables as $table)
			{ 
				if ($table['name'] == $mytable)
				{
					return TRUE;  
				}
			}
		}
	}

	// function which is expected to return something need to return something always
	return FALSE;
}

function get_archs_fromdb()
{
	return db_query("SELECT DISTINCT p_arch FROM packagess ORDER BY p_arch");
}

function db_query($query)
{
	global $db_name;

	$result = FALSE;

	if($db_h = sqlite_open($db_name))
	{
		if($query_h = sqlite_query ($db_h, $query))
		{
			$result = sqlite_fetch_all ($query_h, SQLITE_ASSOC);
		}

		sqlite_close($db_h);
	}

	return ($result);
}

function test_insert_ipkgs ($db) 
{

	sqlite_query($db,
		"INSERT INTO feeds (f_name,           f_uri)
		VALUES             ('3541-base',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/base')
		");

	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-opie',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/opie')
		");

	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-perl',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/perl')
		");
	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-python',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/python')
		");
	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-upgrades',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/upgrades')
		");
	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-x11',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/x11')
		");
	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-machine-c7x0',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/machine/c7x0')
		");
	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-machine-spitz',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/machine/spitz')
		");
	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-machine-akita',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/machine/akita')
		");

	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-upgrades-machine-akita',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/upgrades/machine/akita')
		");

	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-upgrades-machine-c7x0',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/upgrades/machine/c7x0')
		");

	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-upgrades-machine-spitz',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/upgrades/machine/spitz')
		");

	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('3541-upgrades-machine-tosa',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4.1/feed/upgrades/machine/tosa')
		");

	sqlite_query($db,
		"INSERT INTO feeds (f_name,           f_uri)
		VALUES             ('354-base',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4/feed/base')
		");

	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('354-opie',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4/feed/opie')
		");

	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('354-x11',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4/feed/x11')
		");

	sqlite_query($db,
		"INSERT INTO feeds (f_name,             f_uri)
		VALUES             ('354-upgrades',    'http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/3.5.4/feed/upgrades')
		");

}

function searchletter($searchletter)
{
	$ipkgoutput = "<div id='letters'>";
	$alfabet = array('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y');

	foreach($alfabet as $letter)
	{
		if($letter == $searchletter)
		{
			$ipkgoutput .= sprintf(" %s |", $letter );
		}
		else
		{
			$ipkgoutput .= sprintf(" <a href='?action=letter&g=%s'>%s</a> |", $letter, $letter );
		}
	}

	$ipkgoutput .= " <a href='?action=letter&g=z'>z</a></div>";

	if(isset($searchletter)) 
	{
		$ipkgoutput .= searchpkg("$searchletter%");
	}

	return $ipkgoutput;
}

function searchpkg ($searchword)
{
	$result = db_query("SELECT DISTINCT p_name,p_desc,p_section  FROM packages WHERE p_name LIKE '$searchword' ORDER BY p_name ASC;");    

	$ipkgoutput = "<table>\n";
	$ipkgoutput .="<tr><th>Package</th><th>Section</th><th>Description</th></tr>\n";

	foreach($result as $package)
	{
		if (!strstr ($package['p_name'], 'locale'))
		{
			if(strlen($package['p_desc']) > 40)
			{
				$pos = strpos($package['p_desc'],' ',  40);

				if($pos)
				{
					$package['p_desc'] = substr($package['p_desc'], 0, $pos) . '...';
				}
			}

			$ipkgoutput .= sprintf
				("<tr><td><a href='?action=details&pnm=%s'>%s</a></td><td><a href=\"?action=section&section=%s\">%s</a></td><td> %s</td>\n",
				urlencode($package['p_name']), $package['p_name'], $package['p_section'], $package['p_section'], $package['p_desc']);
		}

	}
	
	$ipkgoutput .= '</table>';

	return $ipkgoutput;
}

function searchsection($section)
{
	$result= db_query("SELECT DISTINCT p_name,p_desc,p_section FROM packages WHERE p_section like '$section%' order by p_section asc, p_name asc;");

	$ipkgoutput = "<table>\n";
	$ipkgoutput .="<tr><th>Package</th><th>Section</th><th>Description</th></tr>\n";

	foreach($result as $package)
	{
		if (!strstr ($package['p_name'], 'locale'))
		{
			if(strlen($package['p_desc'])> 40)
			{
				$pos = strpos($package['p_desc'],' ',  40);

				if($pos)
				{
					$package['p_desc'] = substr($package['p_desc'], 0, $pos) . '...';
				}
			}

			$ipkgoutput .= sprintf ("<tr><td><a href='?action=details&pnm=%s'>%s</a></td><td><a href=\"?action=section&section=%s\">%s</a></td><td>%s</td>",
				urlencode($package['p_name']),
				$package['p_name'],
				$package['p_section'], $package['p_section'],
				$package['p_desc']);
		}//if strstr
	}

	$ipkgoutput .= "</table>\n";

	return $ipkgoutput;
}

function pkgdetails ($package)
{
	$result = db_query("SELECT * FROM packages,feeds WHERE packages.p_name='$package' AND feeds.f_name = packages.p_feed");
	
	// display first result

	if ($result)
	{
		$package = $result[0];

		$details = sprintf("<h1>Package details for %s %s</h1>", $package['packages.p_name'], $package['packages.p_version']);
		$details .= sprintf ("<p id='description'>%s</p>", $package['packages.p_desc']);
		$details .= "<table>";

		$details .= sprintf ("\n<tr><td>Maintainer:</td><td>%s</td>", htmlentities(str_replace('@', ' at ', $package['packages.p_maintainer'])));
		
		if($package['packages.p_homepage']) 
		{
			$details .= sprintf ("\n<tr><td>Homepage:</td><td>%s</td>", $package['packages.p_homepage']);
		}

		if($package['packages.p_section'])
		{
			$details .= sprintf ("\n<tr><td>Section:</td><td><a href='?action=section&section=%s'>%s</td>", $package['packages.p_section'],$package['packages.p_section']);
		}
		
		if($package['packages.p_depends'])
		{
			$details .= sprintf ("\n<tr><td>Depends:</td><td>%s</td>", addlinks ($package['packages.p_depends']));
		}
		
		if($package['packages.p_recommends'])
		{
			$details .= sprintf ("\n<tr><td>Recommends:</td><td>%s</td>", addlinks ($package['packages.p_recommends']));
		}
		
		if($package['packages.p_replaces'])
		{
			$details .= sprintf ("\n<tr><td>Replaces:</td><td>%s</td>", addlinks ($package['packages.p_replaces']));
		}
		
		if($package['packages.p_provides'])
		{
			$details .= sprintf ("\n<tr><td>Provides:</td><td>%s</td>", addlinks ($package['packages.p_provides']));
		}
		
		if($package['packages.p_conflicts'])
		{
			$details .= sprintf ("\n<tr><td>Conflicts:</td><td>%s</td>", addlinks ($package['packages.p_conflicts']));
		}
		
		$size = $package['packages.p_size'];

		if(strlen($size) > 6) 
		{
			$size = sprintf("%02.2f Megabytes", $size / (1024 * 1024));
		}

		if(strlen($size) > 3 && strlen($size) < 7) 
		{
			$size = sprintf("%02.2f Kilobytes", $size / (1024 ));
		}

		if(strlen($size) < 4) 
		{
			$size = sprintf("%s Bytes", $size);
		}

		$details .= sprintf ("\n<tr><td>Size:</td><td>%s</td></tr></table>", $size);

		if($package['packages.p_source'])
		{
			$sourcearray = explode (" ", $package['packages.p_source']);

			$details .= "\n<h2>Source:</h2><ul>";

			foreach ($sourcearray as $key => $source_url)
			{
				if (substr ($source_url, 0, 4) == "http" || substr ($source_url, 0, 3) == "ftp")
				{
					$url_parts = parse_url($source_url);

					$details .= sprintf ("<li><a href='%s'>%s</a></li>", $source_url, array_pop(explode('/', $url_parts['path'])));
				}
				else
				{
					$details .= sprintf ("<li>%s</li>", $source_url);
				}
			}

			$details .= '</ul>';

		}

		$details .= "\n<h2>Available versions and architectures:</h2><ul>\n";

		foreach($result as $packages_a)
		{
			$details .= sprintf("\n<li><a href='%s'>%s %s</a> for %s</li>\n",
				$packages_a['feeds.f_uri']."/".$packages_a['packages.p_file'],
				$packages_a['packages.p_name'],
				$packages_a['packages.p_version'],
				$packages_a['packages.p_arch']);
		}

		$details .= "</ul>\n";
	}
	else
	{
		$details = "<h1>Sorry, package not found\n</h1><a href='./'>return</a>\n";
	}

	return $details;
}

function addlinks ($input)
{
	// split input elements up
	$elements = preg_split ('/[\s,]+/', $input);

	$offset = 0;

	foreach ($elements as $element)
	{
		// skip version information and empty elements (shouldn't happend)
		if (!eregi('^([0-9a-z\-]*)$', $element) OR empty($element))
		{ 
			continue;
		}

		// do we have this package in the db?
		$result =  db_query ("SELECT DISTINCT p_name FROM packages WHERE p_name='{$element}'");    

		if(isset($result[0]['p_name']))
		{
			// find position of string in line
			$pos = strpos ($input, $element, $offset);
			$link = sprintf("<a href=\"?action=details&pnm=%s\">$element</a>", urlencode ($element));

			// replace element with a link
			$input = substr_replace ($input, $link, $pos, strlen ($element));

			// update offset
			$offset = ($pos + strlen ($link));
		}
		else
		{
			$offset += strlen ($element);
		}
	}


	return $input;
} 

function sectionslist()
{
	$ipkgoutput = '';

	if($result =  db_query ("SELECT DISTINCT p_section FROM packages ORDER BY p_section"))
	{
		$ipkgoutput = "<ul>\n";

		foreach($result as $item)
		{
			$ipkgoutput .= sprintf ("<li><a href='?action=section&section=%s'>%s</a></li>",
				urlencode($item['p_section']),
				$item['p_section']);
		}

		$ipkgoutput .= "</ul>\n";
	}

	return $ipkgoutput;
}

?>
