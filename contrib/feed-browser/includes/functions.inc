<?php
/*
 * (c) Koen Kooi 2006
 * (c) Marcin Juszkiewicz 2006
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

error_reporting(E_ALL);

define('DB_FILENAME', './feeds.db');

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

function searchletter($searchletter = '')
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
			$ipkgoutput .= sprintf(" <a href='?action=letter&amp;g=%s' title='packages which names begins with \"%s\"'>%s</a> |", $letter, $letter, $letter );
		}
	}

	$ipkgoutput .= " <a href='?action=letter&amp;g=z' title='packages which names begins with \"z\"'>z</a></div>";

	return $ipkgoutput;
}

function searchpkg ($searchword)
{
	if($result = db_query("SELECT DISTINCT p_name,p_desc,p_section  FROM packages WHERE p_name LIKE '$searchword' ORDER BY p_name ASC"))
	{
	    return generate_list_of_packages($result);
	}
}

function generate_list_of_packages($query_result)
{
	$ipkgoutput = "<table>\n";
	$ipkgoutput .="<tr><th>Package</th><th>Section</th><th>Description</th></tr>\n";

	foreach($query_result as $package)
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
				("<tr><td><a href='?action=details&amp;pnm=%s'>%s</a></td><td><a href=\"?action=section&amp;section=%s\">%s</a></td><td> %s</td></tr>\n",
				urlencode($package['p_name']), $package['p_name'], $package['p_section'], $package['p_section'], htmlentities($package['p_desc']));
		}

	}
	
	$ipkgoutput .= '</table>';

	return $ipkgoutput;
}

function searchsection($section)
{
	if($result = db_query("SELECT DISTINCT p_name,p_desc,p_section FROM packages WHERE p_section LIKE '$section%' ORDER BY p_section ASC, p_name ASC"))
	{	
	    return generate_list_of_packages($result);
	}
}

function pkgdetails ($package)
{
	$result = db_query("SELECT * FROM packages,feeds
				WHERE (packages.p_name='$package' OR packages.p_provides='$package')
				    AND feeds.f_name = packages.p_feed 
				ORDER BY packages.p_version DESC, feeds.f_name ASC, packages.p_arch DESC ");
	
	// display first result

	if ($result)
	{
		$package = $result[0];

		$details = sprintf("<h1>Package details for %s %s</h1>", $package['packages.p_name'], $package['packages.p_version']);
		$details .= sprintf ("<p id='description'>%s</p>", htmlentities($package['packages.p_desc']));
		$details .= "<dl>";

		$details .= sprintf ("\n<dt>Maintainer:</dt><dd>%s</dd>", str_replace(array('@',', '), array(' at ', '<br />'), htmlentities($package['packages.p_maintainer'])));
		
		if($package['packages.p_homepage']) 
		{
			$details .= sprintf ("\n<dt>Homepage:</dt><dd>%s</dd>", $package['packages.p_homepage']);
		}

		if($package['packages.p_section'])
		{
			$details .= sprintf ("\n<dt>Section:</dt><dd><a href='?action=section&amp;section=%s'>%s</a></dd>", $package['packages.p_section'],$package['packages.p_section']);
		}
		
		if($package['packages.p_depends'])
		{
			$details .= sprintf ("\n<dt>Depends:</dt><dd>%s</dd>", addlinks ($package['packages.p_depends']));
		}
		
		if($package['packages.p_recommends'])
		{
			$details .= sprintf ("\n<dt>Recommends:</dt><dd>%s</dd>", addlinks ($package['packages.p_recommends']));
		}
		
		if($package['packages.p_replaces'])
		{
			$details .= sprintf ("\n<dt>Replaces:</dt><dd>%s</dd>", addlinks ($package['packages.p_replaces']));
		}
		
		if($package['packages.p_provides'])
		{
			$details .= sprintf ("\n<dt>Provides:</dt><dd>%s</dd>", addlinks ($package['packages.p_provides']));
		}
		
		if($package['packages.p_conflicts'])
		{
			$details .= sprintf ("\n<dt>Conflicts:</dt><dd>%s</dd>", addlinks ($package['packages.p_conflicts']));
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

		$details .= sprintf ("\n<dt>Size:</dt><dd>%s</dd></dl>", $size);

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

		$details .= "\n<h2>Available versions and architectures:</h2><ul id='download'>\n";

		foreach($result as $packages_a)
		{
			$details .= sprintf("\n<li><a class='download' href='%s' title='%s %s for %s'>%s %s</a> for %s (%s feed)</li>\n",
				$packages_a['feeds.f_uri']."/".$packages_a['packages.p_file'],
				$packages_a['packages.p_name'],
				$packages_a['packages.p_version'],
				$packages_a['packages.p_arch'],
				$packages_a['packages.p_name'],
				$packages_a['packages.p_version'],
				$packages_a['packages.p_arch'],
				$packages_a['feeds.f_name']
			);
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
	$elements = explode (', ', $input);

	$offset = 0;

	foreach ($elements as $element)
	{
		// strip version number
		$element = ereg_replace('^(.*)( \((.*)\))+$', '\\1', $element);

		// do we have this package in the db?
		$result =  db_query ("SELECT DISTINCT p_name FROM packages WHERE p_name='{$element}' OR p_provides='{$element}'");    

		if(isset($result[0]['p_name']))
		{
			// find position of string in line
			$pos = strpos ($input, $element, $offset);
			$link = sprintf("<a href=\"?action=details&amp;pnm=%s\">$element</a>", urlencode ($element));

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
		$ipkgoutput = "<ul id='sections'>\n";

		$section_up = $result[0]['p_section'];
		$section_level = FALSE;
		$opie_top = FALSE;

		foreach($result as $item)
		{
			$section_name = $item['p_section'];

			if(0 === strpos($section_name, 'opie') AND !$opie_top)
			{
				$opie_top = TRUE;

				$section_up = 'opie';
			}
			elseif($opie_top AND 0 !== strpos($section_name, 'opie'))
			{
				$opie_top = FALSE;
			}

			if(
				strpos($section_name, '/')		// subsection
			)
			{
				if(0 === strpos($section_name, $section_up . '/'))	// console/network are not part of console/net
				{
					if(!$section_level)
					{
						$ipkgoutput .= '<li><ul class="subsections">';
					}

					$section_name = str_replace($section_up . '/', '', $item['p_section']);
					$section_level = TRUE;
				}
			}
			elseif($section_level)
			{
				$section_up = $section_name;
				$ipkgoutput .= '</ul></li>';
				$section_level = FALSE;
			}
			else
			{
				$section_up = $section_name;
			}

			$ipkgoutput .= sprintf ("<li><a href='?action=section&amp;section=%s' title='%s'>%s</a></li>",
				urlencode($item['p_section']),
				urlencode($item['p_section']),
				$section_name);
		}

		if($section_level)
		{
		    $ipkgoutput .= '</ul></li>';
		}

		$ipkgoutput .= "</ul>\n";
	}

	return $ipkgoutput;
}

function check_database()
{
	if($db = sqlite_open(DB_FILENAME))
	{
		//initialize db
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

		sqlite_close($db);
	}
}



?>
