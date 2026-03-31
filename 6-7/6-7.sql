/*
問1：従業員名と部署名
SELECT e.name AS employee_name, d.name AS department_name
FROM employees e
JOIN departments d ON e.department_id = d.id;

問2：部門ごとの平均給与
SELECT d.name AS department_name, AVG(e.salary) AS avg_salary
FROM departments d
JOIN employees e ON d.id = e.department_id
GROUP BY d.name;

問3：プロジェクトごとの合計作業時間
SELECT p.name AS project_name, SUM(ep.hours) AS total_hours
FROM projects p
JOIN employee_projects ep ON p.id = ep.project_id
GROUP BY p.name;

問4：最も給与が高い従業員
SELECT name, salary
FROM employees
WHERE salary = (SELECT MAX(salary) FROM employees);

問5：プロジェクトに参加していない従業員
SELECT e.name
FROM employees e
LEFT JOIN employee_projects ep ON e.id = ep.employee_id
WHERE ep.employee_id IS NULL;

問6：作業時間が50時間以上の従業員とプロジェクト
SELECT e.name AS employee_name, p.name AS project_name, ep.hours
FROM employee_projects ep
JOIN employees e ON ep.employee_id = e.id
JOIN projects p ON ep.project_id = p.id
WHERE ep.hours >= 50;

問7：開発部門の従業員（給与高い順）
SELECT e.name, e.salary
FROM employees e
JOIN departments d ON e.department_id = d.id
WHERE d.name = '開発'
ORDER BY e.salary DESC;

問8：従業員ごとの合計作業時間（多い順）
SELECT e.name AS employee_name, SUM(ep.hours) AS total_hours
FROM employees e
JOIN employee_projects ep ON e.id = ep.employee_id
GROUP BY e.name
ORDER BY total_hours DESC;