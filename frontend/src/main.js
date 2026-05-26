import './style.css'

const app = document.querySelector('#app')

async function renderPortfolioLayout() {
  const response = await fetch('/portfolio.html')
  if (!response.ok) {
    throw new Error(`Unable to load /portfolio.html (status ${response.status})`)
  }

  app.innerHTML = await response.text()
}

function createProjectCard(project) {
  const card = document.createElement('article')
  card.className = 'card'

  const title = document.createElement('h3')
  title.className = 'card-title'
  title.textContent = project.title || "Project's title"

  const description = document.createElement('p')
  description.className = 'project-desc'
  description.textContent = project.description || 'No description available.'

  const technologies = document.createElement('p')
  technologies.className = 'project-meta'
  technologies.textContent = `Tech: ${project.technologies || ''}`

  card.append(title, description, technologies)

  if (project.githubUrl) {
    const link = document.createElement('a')
    link.className = 'project-link'
    link.href = project.githubUrl
    link.target = '_blank'
    link.rel = 'noreferrer noopener'
    link.textContent = 'Repository'
    card.appendChild(link)
  }

  return card
}

function renderProjects(projects) {
  const projectsList = document.querySelector('#projects-list')
  projectsList.innerHTML = ''

  const featuredProjects = Array.isArray(projects)
    ? projects.filter((project) => project && project.featured === true)
    : []

  if (featuredProjects.length === 0) {
    const empty = document.createElement('p')
    empty.className = 'status-text'
    empty.textContent = 'No featured projects found.'
    projectsList.appendChild(empty)
    return
  }

  featuredProjects.forEach((project) => {
    projectsList.appendChild(createProjectCard(project))
  })
}

async function loadProjects() {
  const projectsList = document.querySelector('#projects-list')

  try {
    const response = await fetch('/api/projects')
    if (!response.ok) {
      throw new Error(`Request failed with status ${response.status}`)
    }

    const projects = await response.json()
    renderProjects(projects)
  } catch (error) {
    projectsList.innerHTML = `
      <p class="status-text">
        Unable to load projects from <code>/api/projects</code>. Please make sure the backend is running.
      </p>
    `
  }
}

async function bootstrap() {
  try {
    await renderPortfolioLayout()
  } catch (error) {
    app.innerHTML = `
      <main class="page">
        <section class="section">
          <h1>Portfolio</h1>
          <p class="status-text">
            Unable to load page layout. Please make sure <code>/portfolio.html</code> exists.
          </p>
        </section>
      </main>
    `
    return
  }

  const contactForm = document.querySelector('#contact-form')
  const contactFeedback = document.querySelector('#contact-feedback')

  if (contactForm && contactFeedback) {
    contactForm.addEventListener('submit', (event) => {
      event.preventDefault()
      contactFeedback.textContent = 'Thanks for your message. I will get back to you soon.'
      contactForm.reset()
    })
  }

  loadProjects()
}

bootstrap()
