SELECT violation_info FROM violation WHERE srcode = '22-36923'

UPDATE violation
SET violation_info = NULL
WHERE srcode = '22-36923';

DELETE FROM violation
WHERE srcode = '22-36923';
